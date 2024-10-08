import ComposeApp
import SwiftUI

struct RootContainer<Content: View>: View {
    private let content: () -> Content

    // These 2 states will sync from Compose world via Flow async.
    @State private var statusBarColor = Color.clear
    @State private var navigationBarColor = Color.clear
    @State private var backgroundColor = Color.black

    public init(@ViewBuilder content: @escaping () -> Content) {
        self.content = content
    }

    var body: some View {
        GeometryReader { proxy in
            content()
                .overlay {
                    VStack {
                        statusBarColor.frame(
                            height: proxy.safeAreaInsets.top
                        )
                        .collect(
                            flow: WindowColorState.shared.statusBarColor
                        ) { color in
                            statusBarColor = Color(color)
                        }
                        Spacer()
                        navigationBarColor.frame(
                            height: proxy.safeAreaInsets.bottom
                        )
                        .collect(
                            flow: WindowColorState.shared.navigationBarColor
                        ) { color in
                            navigationBarColor = Color(color)
                        }
                    }
                }
                .background(backgroundColor)
                .collect(flow: WindowColorState.shared.backgroundColor) {
                    color in
                    backgroundColor = Color(color)
                }
                .ignoresSafeArea(.container, edges: [.top, .bottom])
        }
    }
}
