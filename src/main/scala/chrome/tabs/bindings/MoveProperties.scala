package chrome.tabs.bindings


import scala.scalajs.js

import chrome.windows.bindings.Window

object MoveProperties {

  def apply(windowId: js.UndefOr[Window.Id] = js.undefined,
            index: Int): MoveProperties = {
    js.Dynamic.literal(
      windowId = windowId,
      index = index
    ).asInstanceOf[MoveProperties]
  }

}

class MoveProperties extends js.Object {

  def windowId: js.UndefOr[Window.Id] = js.native
  def index: Int = js.native

}