export function updateThemeColor(bgColor) {
    if (document.querySelectorAll('meta[name="theme-color"]').length > 0) {
        var metaThemeColor = document.querySelector("meta[name=theme-color]");
        metaThemeColor.setAttribute("content", bgColor);
    } else {
        var link = document.createElement('meta');
        link.setAttribute('name', 'theme-color');
        link.setAttribute('content', bgColor);
        document.getElementsByTagName('head')[0].appendChild(link);
    }
}