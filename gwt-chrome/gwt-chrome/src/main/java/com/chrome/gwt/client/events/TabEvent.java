/*
 * Copyright 2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.chrome.gwt.client.events;

import com.chrome.gwt.client.Tabs.Tab;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wraps several events from chrome.tabs.
 * 
 * See documentation at: <a href=
 * "http://dev.chromium.org/developers/design-documents/extensions/tabs-api"
 * >Tabs API</a>
 */
public final class TabEvent extends Event {
  /**
   * Callback for events that return a single tab in the first argument.
   */
  public interface Listener {
    void onTab(Tab tab);
  }

  protected TabEvent() {
  }

  public ListenerHandle addListener(Listener listener) {
    return new ListenerHandle(this, addListenerImpl(listener));
  }

  private native JavaScriptObject addListenerImpl(Listener listener) /*-{
    var handle = function(tab) {
      listener.
          @com.chrome.gwt.client.events.TabEvent.Listener::onTab(Lcom/chrome/gwt/client/Tabs$Tab;)
          (tab);
    }

    this.addListener(handle);
    return handle;
  }-*/;
}