# scroll_webview_issue
This sample illustrates a scrolling issue that was introduced the 4th of June when Chrome was updated.<br/><br/>
When adding the style <br/>document.documentElement.style.overflow = "hidden" <br/> the scrolling breaks if Chrome is enabled on your Android phone (tested on Nokia 7 plus running Android 9). <br/>When disabling Chrome, the scrolling works again.<br/><br/>
The sample app has a BREAK_SCROLLING boolean that can be toggled to see the difference of having 
document.documentElement.style.overflow = "hidden" 
added or not.
Note that the scrolling does not break on the android emulator (properly don't have the Chrome update), therefore a real device needs to be used for testing
