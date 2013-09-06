# DateTimePickerCompat

DateTimePickerCompat is a backport version of the official [DateTimePicker][1] for Android 4.2.2+.


Usage
-----

Using this library is exactly the same as using the official one.

First of all you need to get a new instance of the dialog you want to use:

      // For DatePickerDialog
      DatePickerDialog dialog = DatePickerDialog.newInstance(OnDateSetListener, year, month, day);
      
      // For TimePickerDialog
      TimePickerDialog dialog = TimePickerDialog.newInstance(OnTimeSetListener, hour, minutes, is24HourMode);



With an instance of the Dialog the next step is to show it:

      // The structure is the same on both cases 
      dialog.show(FragmentManager, Tag);




License
-------

       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.


[1]:https://android.googlesource.com/platform/frameworks/opt/datetimepicker/