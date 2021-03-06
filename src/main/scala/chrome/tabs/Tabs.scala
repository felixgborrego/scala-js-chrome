package chrome.tabs

import chrome.events.Event
import chrome.runtime.bindings.Port
import chrome.tabs.bindings._
import chrome.windows.bindings.Window

import scala.concurrent.{Promise, Future}
import scala.scalajs.js
import scala.scalajs.js.UndefOr


object Tabs {

  def get(tabId: Tab.Id): Future[Tab] = {
    val promise = Promise[Tab]
    bindings.Tabs.get(tabId, (tab: Tab) => {
      promise.complete(chrome.lastErrorOrValue(tab))
    })
    promise.future
  }
  
  
  def getCurrent: Future[Tab] = {
    val promise = Promise[Tab]
    bindings.Tabs.getCurrent((tab: Tab) => {
      promise.complete(chrome.lastErrorOrValue(tab))
    })
    promise.future
  }
  
  def connect(tabId: Tab.Id, connectInfo: js.UndefOr[ConnectInfo] = js.undefined): Port = bindings.Tabs.connect(tabId, connectInfo)

  def sendRequest(tabId: Tab.Id, request: js.Any): Future[js.Any] = {
    val promise = Promise[js.Any]
    bindings.Tabs.sendRequest(tabId, request, js.Any.fromFunction1((response: js.Any) => {
      promise.complete(chrome.lastErrorOrValue(response))
    }))
    promise.future
  }
  
  def sendMessage(tabId: Tab.Id, message: js.Any, options: js.UndefOr[MessageOptions] = js.undefined): Future[js.Any] = {
    val promise = Promise[js.Any]
    bindings.Tabs.sendMessage(tabId, message, options, js.Any.fromFunction1((response: js.Any) => {
      promise.complete(chrome.lastErrorOrValue(response))
    }))
    promise.future
  }

  def create(createProperties: TabCreateProperties): Future[Tab] = {
    val promise = Promise[Tab]
    bindings.Tabs.create(createProperties, js.Any.fromFunction1((tab: Tab) => {
      promise.complete(chrome.lastErrorOrValue(tab))
    }))
    promise.future
  }
  
  def duplicate(tabId: Tab.Id): Future[UndefOr[Tab]] = {
    val promise = Promise[js.UndefOr[Tab]]
    bindings.Tabs.duplicate(tabId, js.Any.fromFunction1((tab: js.UndefOr[Tab]) => {
      promise.complete(chrome.lastErrorOrValue(tab))
    }))
    promise.future
  }

  def query(queryInfo: TabQuery): Future[js.Array[Tab]] = {
    val promise = Promise[js.Array[Tab]]
    bindings.Tabs.query(queryInfo, js.Any.fromFunction1((tabs: js.Array[Tab]) => {
      promise.complete(chrome.lastErrorOrValue(tabs))
    }))
    promise.future
  }

  def highlight(highlightInfo: HighlightInfo): Future[Window] = {
    val promise = Promise[Window]
    bindings.Tabs.highlight(highlightInfo, js.Any.fromFunction1((window: Window) => {
      promise.complete(chrome.lastErrorOrValue(window))
    }))
    promise.future
  }
  
  def update(tabId: js.UndefOr[Tab.Id] = js.undefined, updateProperties: UpdateProperties): Future[js.UndefOr[Tab]] = {
    val promise = Promise[js.UndefOr[Tab]]
    bindings.Tabs.update(tabId, updateProperties, js.Any.fromFunction1((tabs: js.UndefOr[Tab]) => {
      promise.complete(chrome.lastErrorOrValue(tabs))
    }))
    promise.future
  }
  
  def move(tabIds: js.Array[Tab.Id], moveProperties: MoveProperties): Future[js.Array[Tab]] = {
    val promise = Promise[js.Array[Tab]]
    bindings.Tabs.move(tabIds, moveProperties, js.Any.fromFunction1((tabs: js.Any) => {
        promise.complete(
          chrome.lastErrorOrValue(tabs match {
            case array: js.Array[Tab] => array
            case tab: Tab => js.Array(tab)
          })
        )
    }))
    promise.future
  }
  
  def reload(tabId: js.UndefOr[Tab.Id] = js.undefined, reloadProperties: ReloadProperties): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Tabs.reload(tabId, reloadProperties, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  def remove(tabIds: js.Array[Tab.Id]): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Tabs.remove(tabIds, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def detectLanguage(tabId: js.UndefOr[Tab.Id] = js.undefined): Future[String] = {
    val promise = Promise[String]
    bindings.Tabs.detectLanguage(tabId, js.Any.fromFunction1((language: String) => {
      promise.complete(chrome.lastErrorOrValue(language))
    }))
    promise.future
  }
  
  def captureVisibleTab(windowId: js.UndefOr[Window.Id] = js.undefined, options: js.UndefOr[CaptureOptions] = js.undefined): Future[String] = {
    val promise = Promise[String]
    bindings.Tabs.captureVisibleTab(windowId, options, js.Any.fromFunction1((dataUrl: String) => {
      promise.complete(chrome.lastErrorOrValue(dataUrl))
    }))
    promise.future
  }

  def executeScript(tabId: js.UndefOr[Tab.Id] = js.undefined, details: CodeInjectionOptions): Future[js.UndefOr[js.Array[js.Any]]] = {
    val promise = Promise[js.UndefOr[js.Array[js.Any]]]
    bindings.Tabs.executeScript(tabId, details, js.Any.fromFunction1((result: js.UndefOr[js.Array[js.Any]]) => {
      promise.complete(chrome.lastErrorOrValue(result))
    }))
    promise.future
  }
  
  
  def insertCSS(tabId: js.UndefOr[Tab.Id] = js.undefined, details: CodeInjectionOptions): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Tabs.insertCSS(tabId, details, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }

  def setZoom(tabId: js.UndefOr[Tab.Id] = js.undefined, zoomFactor: Double): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Tabs.setZoom(tabId, zoomFactor, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  def getZoom(tabId: js.UndefOr[Tab.Id] = js.undefined): Future[Double] = {
    val promise = Promise[Double]
    bindings.Tabs.getZoom(tabId, js.Any.fromFunction1((zoomFactor: Double) => {
      promise.complete(chrome.lastErrorOrValue(zoomFactor))
    }))
    promise.future
  }

  def setZoomSettings(tabId: js.UndefOr[Tab.Id] = js.undefined, zoomSettings: ZoomSettings): Future[Unit] = {
    val promise = Promise[Unit]
    bindings.Tabs.setZoomSettings(tabId, zoomSettings, js.Any.fromFunction0(() => {
      promise.complete(chrome.lastErrorOrValue(()))
    }))
    promise.future
  }
  
  def getZoomSettings(tabId: js.UndefOr[Tab.Id] = js.undefined): Future[ZoomSettings] = {
    val promise = Promise[ZoomSettings]
    bindings.Tabs.getZoomSettings(tabId, js.Any.fromFunction1((zoomSettings: ZoomSettings) => {
      promise.complete(chrome.lastErrorOrValue(zoomSettings))
    }))
    promise.future
  }
  
  val onCreated: Event[js.Function1[Tab, _]] = bindings.Tabs.onCreated
  val onUpdated: Event[js.Function3[Tab.Id, ChangeInfo, Tab, _]] = bindings.Tabs.onUpdated
  val onMoved: Event[js.Function2[Tab.Id, MoveInfo, _]] = bindings.Tabs.onMoved
  val onActivated: Event[js.Function1[ActiveInfo, _]] = bindings.Tabs.onActivated
  val onHighlighted: Event[js.Function1[HighlightInfo, _]] = bindings.Tabs.onHighlighted
  val onDetached: Event[js.Function2[Tab.Id, DetachInfo, _]] = bindings.Tabs.onDetached
  val onAttached: Event[js.Function2[Tab.Id, AttachInfo, _]] = bindings.Tabs.onAttached
  val onRemoved: Event[js.Function2[Tab.Id, RemoveInfo, _]] = bindings.Tabs.onRemoved
  val onReplaced: Event[js.Function2[Tab.Id, Tab.Id, _]] = bindings.Tabs.onReplaced
  val onZoomChange: Event[js.Function1[ZoomChangeInfo, _]] = bindings.Tabs.onZoomChange
  

}
