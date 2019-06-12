# scroll_webview_issue
This sample illustrates a scrolling issue that was introduced the 4th of June when Chrome was updated.
When adding document.documentElement.style.overflow = "hidden" the scrolling breaks if Chrome is enabled on your Android phone
(tested on Android 9). When disabling Chrome, the scrolling works again.
The sample app has a BREAK_SCROLLING boolean that can be toggled to see the difference of having 
document.documentElement.style.overflow = "hidden" 
added or not.
