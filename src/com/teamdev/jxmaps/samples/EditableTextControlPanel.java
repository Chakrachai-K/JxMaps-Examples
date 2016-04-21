/*
 * Copyright (c) 2000-2016 TeamDev Ltd. All rights reserved.
 * Use is subject to Apache 2.0 license terms.
 */


package com.teamdev.jxmaps.samples;

public interface EditableTextControlPanel extends ControlPanel {
    void onTextEntered(String value);

    String getInitialText();
}
