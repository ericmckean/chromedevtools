// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk.internal;

import junit.framework.Assert;

import org.chromium.sdk.Breakpoint;
import org.chromium.sdk.Breakpoint.Target;
import org.chromium.sdk.internal.shellprotocol.BrowserImpl;
import org.chromium.sdk.internal.shellprotocol.BrowserTabImpl;
import org.chromium.sdk.internal.shellprotocol.tools.devtools.DevToolsServiceHandler;
import org.chromium.sdk.internal.shellprotocol.tools.v8debugger.ChromeDevToolSessionManager;

/**
 * A utility for performing some common test-related operations.
 */
public class TestUtil {

  public static void assertBreakpointsEqual(Breakpoint bpExpected, Breakpoint bpHit) {
    Assert.assertEquals(bpExpected.getId(), bpHit.getId());
    Assert.assertEquals(bpExpected.getCondition(), bpHit.getCondition());
    Assert.assertEquals(bpExpected.getTarget().accept(BREAKPOINT_TARGET_DUMPER),
        bpHit.getTarget().accept(BREAKPOINT_TARGET_DUMPER));
  }

  private static final Breakpoint.Target.Visitor<String> BREAKPOINT_TARGET_DUMPER =
      new Breakpoint.Target.Visitor<String>() {
    @Override public String visitScriptName(String scriptName) {
      return "name=" + scriptName;
    }
    @Override public String visitScriptId(Object scriptId) {
      return "id=" + scriptId;
    }
    @Override public String visitUnknown(Target target) {
      return "unknown " + target;
    }

  };

  public static DevToolsServiceHandler getDevToolsServiceHandler(BrowserImpl browserImpl) {
    return browserImpl.getDevToolsServiceHandlerForTests();
  }

  public static ChromeDevToolSessionManager getV8DebuggerToolHandler(BrowserTabImpl browserTabImpl) {
    return browserTabImpl.getSessionManager();
  }

  private TestUtil() {
    // not instantiable
  }
}