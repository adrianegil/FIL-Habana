/*
 * Copyright (C) 2020 The Android Open Source Project
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

package cu.desoft.filhabana.data

import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.HomeOption

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {

    fun loadHomeOptions(listNames: Array<String>): List<HomeOption> {
        return listOf<HomeOption>(
            HomeOption(listNames.get(0), R.drawable.product),
            HomeOption(listNames.get(1), R.drawable.product),
            HomeOption(listNames.get(2), R.drawable.product),
            HomeOption(listNames.get(3), R.drawable.product),
            HomeOption(listNames.get(4), R.drawable.product),
            HomeOption(listNames.get(5), R.drawable.product),
            HomeOption(listNames.get(6), R.drawable.product),
            HomeOption(listNames.get(7), R.drawable.product),
        )
    }

}

