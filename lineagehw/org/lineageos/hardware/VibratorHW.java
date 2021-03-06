/*
 * Copyright (C) 2016 The CyanogenMod Project
 * Copyright (C) 2018 The LineageOS Project
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

package org.lineageos.hardware;

import org.lineageos.internal.util.FileUtils;

public class VibratorHW {

    private static String LEVEL_PATH = "/sys/class/timed_output/vibrator/intensity";

    public static boolean isSupported() {
        return FileUtils.isFileReadable(LEVEL_PATH) && FileUtils.isFileWritable(LEVEL_PATH);
    }

    public static int getMaxIntensity()  {
        return 10000;
    }

    public static int getMinIntensity()  {
        return 0;
    }

    public static int getWarningThreshold()  {
        return 9000;
    }

    public static int getCurIntensity()  {
        String actualIntensity = FileUtils.readOneLine(LEVEL_PATH).replace("intensity: ", "");
        return Integer.parseInt(actualIntensity);
    }

    public static int getDefaultIntensity()  {
        return 7500;
    }

    public static boolean setIntensity(int intensity)  {
        return FileUtils.writeLine(LEVEL_PATH, String.valueOf(intensity));
    }
}
