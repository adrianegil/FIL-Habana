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
import cu.desoft.filhabana.data.model.*

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {

    fun loadHomeOptions(listNames: Array<String>): List<HomeOption> {
        return listOf<HomeOption>(
            HomeOption(listNames.get(0), R.drawable.icon_general_information),
            HomeOption(listNames.get(1), R.drawable.icon_map),
            HomeOption(listNames.get(2), R.drawable.icon_subsedes),
            HomeOption(listNames.get(3), R.drawable.icon_participants),
            HomeOption(listNames.get(4), R.drawable.icon_guest),
            HomeOption(listNames.get(5), R.drawable.icon_literary_program),
            HomeOption(listNames.get(6), R.drawable.icon_artistic_program),
            HomeOption(listNames.get(7), R.drawable.icon_child_program),
        )
    }

    fun loadGuestArtists(listGuestArtitsNames: Array<String>): List<GuestArtist> {
        return listOf<GuestArtist>(
            GuestArtist(listGuestArtitsNames.get(0), R.drawable.alejandro),
            GuestArtist(listGuestArtitsNames.get(1), R.drawable.fiorela),
            GuestArtist(listGuestArtitsNames.get(2), R.drawable.hernan),
            GuestArtist(listGuestArtitsNames.get(3), R.drawable.ivan),
            GuestArtist(listGuestArtitsNames.get(4), R.drawable.luis),
            GuestArtist(listGuestArtitsNames.get(5), R.drawable.maria),
            GuestArtist(listGuestArtitsNames.get(6), R.drawable.maria_isabel),
            GuestArtist(listGuestArtitsNames.get(7), R.drawable.mary),
            GuestArtist(listGuestArtitsNames.get(8), R.drawable.oscar),
            GuestArtist(listGuestArtitsNames.get(9), R.drawable.patricio),

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

    fun loadCarps(): List<Carp> {
        return listOf<Carp>(
            Carp("Fase Software", "M??xico", "Literatura, infantil y juvenil"),
            Carp("Ediciones JL", "M??xico", "Literatura, infantil y juvenil"),
            Carp("Multimedia Educativa", "M??xico", "Literatura, infantil y juvenil"),
            Carp(
                "Grupo VL",
                "Per??",
                "Cine y fotograf??a, m??sica y folklor, religi??n y teolog??a, naturaleza y medioambiente, literatura, infantil y juvenil, arte y otros"
            ),
            Carp(
                "El Mundo de los Minilibros",
                "Per??",
                "Autoayuda y superaci??n, literartura, diciionarios, infantil y juvenil, deportes y recreaci??n"
            ),
            Carp("Abordan International", "Rep??blica Dominicana", "Literatura, infantil y juvenil"),
            Carp(
                "Bolivia Distribuidores",
                "Bolivia",
                "Historia, matem??tica, naturaleza y medio ambiente, autoayuda y superaci??n, literatura, infantil y juvenil, ciencias sociales y comunicaci??n"
            ),
            Carp("Organizaci??n Nacional de Bufetes Colectivos ", "Cuba", "Derecho"),
        )
    }

    fun loadStands(): List<Stand> {
        return listOf<Stand>(
            Stand("Editorial Ciencias M??dicas", "A-6-a", "Medicina"),
            Stand(
                "CITMATEL",
                "A-6-b",
                "Literatura infantil y juvenil, ciencias sociales y comunicaci??n, m??sica, folklor y multimedia"
            ),
            Stand("EDUNIV-SOCIT", "A-6-b", "Ciencias sociales y comunicaci??n, sicolog??a"),
            Stand(
                "Sandunga ARTex",
                "A-6-f",
                "Literatura general, arte, folklore, arquitectura y dise??o"
            ),
            Stand("Editorial C??pulas", "A-7-a", "Arte, ciencias sociales y comunicaci??n"),
            Stand(
                "Prensa Latina",
                "A-7-b",
                "Ciencias sociales y comunicaci??n, historia, filosof??a"
            ),
            Stand(
                "Editorial Lazo Adentro",
                "A-7-c",
                "Ciencias sociales y comunicaci??n, religi??n y teolog??a, filosof??a"
            ),
            Stand(
                "Editorial Caminos",
                "A-7-d",
                "Religi??n y teolog??a, humanidades, derecho y filosof??a"
            ),
            Stand("Ediciones ICAIC", "A-7-e", "Ciencias sociales y comunicaci??n, arte"),
            Stand(
                "Fundaci??n Antonio Nu??ez Jimenez",
                "A-7-f",
                "Geograf??a y viajes,ciencias sociales y comunicaci??n, naturaleza y medio ambiente"
            ),
            Stand(
                "Fondo Editorial Casa de las Am??ricas",
                "A-7-g",
                "Literatura general, arte, humanidades, m??sica, folklor"
            ),
            Stand(
                "Publicaciones Acuario",
                "A-7-h",
                "Literatura infantil y juvenil, filosof??a, sicologia, derecho"
            ),
            Stand("Empresa de Correos Habana Este", "A-8-d", "Comunicaci??n"),
            Stand("Alliance Francaise", "A-8-e", "Arte, historia y politica, Comunicaci??n"),
            Stand("Biblioteca Nacional de Cuba", "A-8-f", "Literatura general"),
            Stand("Artes Gr??ficas Federico Engels", "A-8-g", "Historia y pol??tica"),
            Stand(
                "Editorial  F??lix Varela",
                "A-8-h",
                "Derecho, arquitectura y dise??o, arte, ciencias sociales y comunicaci??n"
            ),
            Stand("ETECSA", "C-10", "Comunicaci??n"),
            Stand(
                "Cuadernos Papiros",
                "C-1-a",
                "Administraci??n y gerencia, multimedia y nuevas tecnolog??as, naturaleza y medio ambiente"
            ),
            Stand("Esperanto", "C-1-b", "Esperanto"),
            Stand(
                "Editorial Pueblo y Educaci??n",
                "C-1-c/ A-6-c",
                "Historia, pol??tica, literatura general, ciencia y tecnolog??a"
            ),
            Stand("CPLL Cienfuegos", "C-2-a", "Literatura general"),
            Stand("Editorial Artecubano", "C-2-b", "Arte"),
            Stand("Editorial Arte y Literatura", "C-2-c", "Arte y literatura"),
            Stand(
                "Editorial Nuevo Milenio",
                "C-3",
                "Derecho, geograf??a y viajes, arquitectura y dise??o, ciencias sociales y comunicaci??n, historia, filosof??a, matem??tica."
            ),
            Stand("Sistema Ediciones Territoriales", "C-4", "Literatura general"),
            Stand("Editorial Oriente", "C-5-a", "Literatura general"),
            Stand("Sello Collage Ediciones", "C-5-b", "Arte"),
            Stand("Letras Cubanas", "C-5-c", "Arte, literatura, m??sica y folklor"),
            Stand("Ediciones Vigia", "C-6-a", "Literatura general"),
            Stand("Ediciones Matanzas-Aldabon", "C-6-b", "Literatura general"),
            Stand(
                "Ediciones Uni??n",
                "C-6-c",
                "Arquitectura y dise??o, ciencias sociales y comunicaci??n, historia, literatura infantil y juvenil"
            ),
            Stand("Editorial de La Mujer", "C-7-a", "Ciencias sociales y comunicaci??n"),
            Stand("CPLL Habana", "C-7-c", "Literatura general"),
            Stand("CPLL Holgu??n", "C-7-d", "Literatura general"),
            Stand("ANCI", "C-8-a", "Publicaciones in??ditas de autores ciegos"),
            Stand(
                "Editorial Jose Mart??",
                "C-8-b",
                "Arte, ciencias sociales y comunicaci??n, religi??n y teolog??a"
            ),
            Stand(
                "Centro de Estudios Martianos",
                "C-8-c",
                "Ciencias sociales y comunicaci??n, infantil y juvenil,  pol??tica"
            ),
            Stand(
                "Casa Editora Abril",
                "C-9",
                "Computaci??n e inform??tica, historia, pol??tica, sicolog??a y literatura general"
            ),
            Stand(
                "Ediciones Cubanas ARTex S.A.",
                "D-1",
                "M??sica y folklore, religi??n y teolog??a, artesan??a y manualidades, autoayuda y superaci??n, literatura general, diccionarios y enciclopedias, infantil y juvenil, medicina y obras de interes general"
            ),
            Stand(
                "Editorial Gente Nueva",
                "K-13 y K-14",
                "Literatura infantil, juegos infantiles, historia, humanidades"
            ),
            Stand("Editorial Verde Olivo", "K-5", "Ciencias sociales, historia y pol??tica"),
            Stand(
                "Capit??n San Luis",
                "K-7-a",
                "Pol??tica, historia, naturaleza y medio ambiente, econom??a"
            ),
            Stand("Instituto de Historia", "K-7-a", "Historia y pol??tica"),
            Stand("Centro Fidel Castro", "K-7-b", "Historia y pol??tica"),
            Stand(
                "Oficina de Asuntos Hist??ricos",
                "K-7-b",
                "Historia, literatura general y pol??tica"
            ),
        )
    }
}

