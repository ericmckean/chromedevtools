// Copyright (c) 2010 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk.internal.wip.protocol.input;

import org.chromium.sdk.internal.protocolparser.JsonOptionalField;
import org.chromium.sdk.internal.protocolparser.JsonType;

@JsonType
public interface WipScope {
  boolean hasChildren();

  @JsonOptionalField
  ValueData thisObject();

  String description();

  ValueData.Id objectId();

  @JsonOptionalField
  boolean isLocal();

  @JsonOptionalField
  boolean isClosure();

  @JsonOptionalField
  boolean isWithBlock();

  String type();
}