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

import android.content.Context
import cu.desoft.filhabana.R
import cu.desoft.filhabana.data.model.GuestArtist
import cu.desoft.filhabana.data.model.HomeOption
import cu.desoft.filhabana.data.model.HonoredAuthor
import cu.desoft.filhabana.data.model.Subsede

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {

    fun loadHomeOptions(listNames: Array<String>): List<HomeOption> {
        return listOf<HomeOption>(
            HomeOption(listNames.get(0), R.drawable.icon_general_information),
            HomeOption(listNames.get(1), R.drawable.icon_map),
            HomeOption(listNames.get(2), R.drawable.icon_subsedes),
            HomeOption(listNames.get(3), R.drawable.icon_literary_genres),
            HomeOption(listNames.get(4), R.drawable.icon_guest),
            HomeOption(listNames.get(5), R.drawable.icon_literary_program),
            HomeOption(listNames.get(6), R.drawable.icon_artistic_program),
            HomeOption(listNames.get(7), R.drawable.icon_child_program),
        )
    }

    fun loadGuestArtists(listGuestArtitsNames: Array<String>): List<GuestArtist> {
        return listOf<GuestArtist>(
            GuestArtist(listGuestArtitsNames.get(0), R.drawable.product),
            GuestArtist(listGuestArtitsNames.get(1), R.drawable.product),
            GuestArtist(listGuestArtitsNames.get(2), R.drawable.product),
            GuestArtist(listGuestArtitsNames.get(3), R.drawable.product),
            GuestArtist(listGuestArtitsNames.get(4), R.drawable.product),
        )
    }

    fun loadHonoredAuthors(
        listHonoredAuthorsNames: Array<String>,
        context: Context?
    ): List<HonoredAuthor> {
        return listOf<HonoredAuthor>(
            HonoredAuthor(
                listHonoredAuthorsNames.get(0),
                context!!.getString(R.string.araceli_description),
                false,
                R.drawable.araceli
            ),
            HonoredAuthor(
                listHonoredAuthorsNames.get(1),
                context.getString(R.string.julio_description),
                false,
                R.drawable.julio
            ),
        )
    }
}

