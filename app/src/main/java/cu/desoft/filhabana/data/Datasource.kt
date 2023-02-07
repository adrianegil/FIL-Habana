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
            Carp("Fase Software", "Mexico", "Literatura, infantil y juvenil"),
            Carp("Ediciones JL", "Mexico", "Literatura, infantil y juvenil"),
            Carp("Multimedia Educativa", "Mexico", "Literatura, infantil y juvenil"),
            Carp(
                "Grupo VL",
                "Peru",
                "Cine y fotografia, musica y folklor, religion y teologia, naturaleza y medioambiente, literatura, infantil y juvenil, arte y otros"
            ),
            Carp(
                "El Mundo de los Minilibros",
                "Peru",
                "Autoayuda y superacion, literartura, diciionarios, infantil y juvenil, deportes y recreacion"
            ),
            Carp("Abordan International", "Republica Dominicana", "Literatura, infantil y juvenil"),
            Carp(
                "Bolivia Distribuidores",
                "Bolivia",
                "Historia,matematica,naturaleza y medio ambiente, autoayuda y superacion, literatura, infantil y juvenil, ciencias sociales y comunicación"
            ),
            Carp("Organización Nacional de Bufetes Colectivos ", "Cuba", "Derecho"),
        )
    }

    fun loadStands(): List<Stand> {
        return listOf<Stand>(
            Stand("Editorial Ciencias Medicas", "A-6-a", "Medicina"),
            Stand(
                "CITMATEL",
                "A-6-b",
                "Literatura infantil y juvenil, ciencias sociales y comunicación, musica, folklor y multimedia"
            ),
            Stand("EDUNIV-SOCIT", "A-6-b", "Ciencias sociales y comunicación, sicologia"),
            Stand(
                "Sandunga ARTex",
                "A-6-f",
                "Literatura general, arte, folklore, arquitectura y diseño"
            ),
            Stand("Editorial Cupulas", "A-7-a", "Arte, ciencias sociales y comunicación"),
            Stand(
                "Prensa Latina",
                "A-7-b",
                "Ciencias sociales y comunicación, historia, filosofia"
            ),
            Stand(
                "Editorial Lazo Adentro",
                "A-7-c",
                "Ciencias sociales y comunicación, religion y teologia, filosofia"
            ),
            Stand(
                "Editorial Caminos",
                "A-7-d",
                "Religion y teologia, humanidades, derecho y filosofia"
            ),
            Stand("Ediciones ICAIC", "A-7-e", "Ciencias sociales y comunicación, arte"),
            Stand(
                "Fundacion Antonio Nuñez Jimenez",
                "A-7-f",
                "Geografia y viajes,ciencias sociales y comunicación,naturaleza y medio ambiente"
            ),
            Stand(
                "Fondo Editorial Casa de las Américas",
                "A-7-g",
                "Literatura general, arte, humanidades, musica, folklor"
            ),
            Stand(
                "Publicaciones Acuario",
                "A-7-h",
                "Literatura infantil y juvenil, filosofia, sicologia, derecho"
            ),
            Stand("Empresa de Correos Habana Este", "A-8-d", "Comunicación"),
            Stand("Alliance Francaise", "A-8-e", "Arte, historia y politica, Comunicación"),
            Stand("Biblioteca Nacional de Cuba", "A-8-f", "Literatura general"),
            Stand("Artes Graficas Federico Engels", "A-8-g", "Historia y politica"),
            Stand(
                "Editorial  Félix Varela",
                "A-8-h",
                "Derecho, arquitectura y diseño, arte, ciencias sociales y comunicación"
            ),
            Stand("ETECSA", "C-10", "Comunicación"),
            Stand(
                "Cuadernos Papiros",
                "C-1-a",
                "Administracion y gerencia, multimedia y nuevas tecnologias, naturaleza y medio ambiente"
            ),
            Stand("Esperanto", "C-1-b", "Esperanto"),
            Stand(
                "Editorial Pueblo y Educación",
                "C-1-c/ A-6-c",
                "Historia, politica, literatura general, ciencia y tecnologia"
            ),
            Stand("CPLL Cienfuegos", "C-2-a", "Literatura general"),
            Stand("Editorial Artecubano", "C-2-b", "Arte"),
            Stand("Editorial Arte y Literatura", "C-2-c", "Arte y literatura"),
            Stand(
                "Editorial Nuevo Milenio",
                "C-3",
                "Derecho, geografia y viajes,arquitectura y diseño, ciencias sociales y comunicación, historia, filosofia, matematica."
            ),
            Stand("Sistema Ediciones Territoriales", "C-4", "Literatura general"),
            Stand("Editorial Oriente", "C-5-a", "Literatura general"),
            Stand("Sello Collage Ediciones", "C-5-b", "Arte"),
            Stand("Letras Cubanas", "C-5-c", "Arte, literatura,musica y folklor"),
            Stand("Ediciones Vigia", "C-6-a", "Literatura general"),
            Stand("Ediciones Matanzas-Aldabon", "C-6-b", "Literatura general"),
            Stand(
                "Ediciones Unión",
                "C-6-c",
                "Arquitectura y diseño, ciencias sociales y comunicación, historia, literatura infantil y juvenil"
            ),
            Stand("Editorial de La Mujer", "C-7-a", "Ciencias sociales y comunicación"),
            Stand("CPLL Habana", "C-7-c", "Literatura general"),
            Stand("CPLL Holguín", "C-7-d", "Literatura general"),
            Stand("ANCI", "C-8-a", "Publicaciones ineditas de autores ciegos"),
            Stand(
                "Editorial Jose Martí",
                "C-8-b",
                "Arte, ciencias sociales y comunicación, religion y teologia"
            ),
            Stand(
                "Centro de Estudios Martianos",
                "C-8-c",
                "Ciencias sociales y comunicación, infantil y juvenil,  politica"
            ),
            Stand(
                "Casa Editora Abril",
                "C-9",
                "Computacion e informatica, historia, politica, sicologia y literatura general"
            ),
            Stand(
                "Ediciones Cubanas ARTex S.A.",
                "D-1",
                "Musica y folklore, religion y teologia, artesania y manualidades, autoayuda y superacion, literatura general, diccionarios y enciclopedias, infantil y juvenil, medicina y obras de interes general"
            ),
            Stand(
                "Editorial Gente Nueva",
                "K-13 y K-14",
                "Literatura infantil, juegos infantiles, historia, humanidades"
            ),
            Stand("Editorial Verde Olivo", "K-5", "Ciencias sociales, historia y politica"),
            Stand(
                "Capitán San Luis",
                "K-7-a",
                "Politica, historia, naturaleza y medio ambiente, economia"
            ),
            Stand("Instituto de Historia", "K-7-a", "Historia y politica"),
            Stand("Centro Fidel Castro", "K-7-b", "Historia y politica"),
            Stand(
                "Oficina de Asuntos Históricos",
                "K-7-b",
                "Historia, literatura general y politica"
            ),
        )
    }
}

