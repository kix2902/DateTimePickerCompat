/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redinput.datetimepickercompat;

import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.TextView;

/**
 * Fake Button class, used so TextViews can announce themselves as Buttons, for accessibility.
 */
public class AccessibleTextView extends TextView {

	public AccessibleTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		installAccessibilityDelegate();
	}

	private void installAccessibilityDelegate() {
		// The accessibility delegate enables customizing accessibility behavior
		// via composition as opposed as inheritance. The main benefit is that
		// one can write a backwards compatible application by setting the delegate
		// only if the API level is high enough i.e. the delegate is part of the APIs.
		// The easiest way to achieve that is by using the support library which
		// takes the burden of checking API version and knowing which API version
		// introduced the delegate off the developer.
		ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {

			@Override
			public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
				super.onInitializeAccessibilityEvent(host, event);
				// Note that View.onInitializeAccessibilityNodeInfo was introduced in
				// ICS and we would like to tweak a bit the text that is reported to
				// accessibility services via the AccessibilityNodeInfo.
				event.getText().add(Button.class.getName());
			}

			@Override
			public void onInitializeAccessibilityNodeInfo(View host,
					AccessibilityNodeInfoCompat info) {
				super.onInitializeAccessibilityNodeInfo(host, info);
				// Note that View.onInitializeAccessibilityNodeInfo was introduced in
				// ICS and we would like to tweak a bit the text that is reported to
				// accessibility services via the AccessibilityNodeInfo.
				info.setText(Button.class.getName());
			}
		});
	}

}
