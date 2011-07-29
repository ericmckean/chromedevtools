// Copyright (c) 2011 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk.internal.v8native.protocol.input;

import org.chromium.sdk.internal.protocolparser.JsonProtocolParser;
import org.chromium.sdk.internal.v8native.protocol.input.V8DynamicParser;

/**
 * An accessor to dynamic implementation of a v8 protocol parser. Should be replaceable with
 * a similar class that provides access to generated parser implementation.
 */
public class V8ProtocolParserAccess {
  public static JsonProtocolParser get() {
    return V8DynamicParser.get();
  }
}
