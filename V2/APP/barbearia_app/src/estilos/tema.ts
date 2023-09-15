import { extendTheme } from "native-base"

export const TEMAS = extendTheme(
    {
        body: {
            corFundo: '#202020'
        },
        colors: {
            marrom: {
                normal: '#B08E51',
                normalClaro: '#E1C8B9',
                claro: '#E4DCD3',
                muitoClaro: '#E8E6E2'
            },
            cinza: {
                cinzaBlack: '#202020',
                cinzaEscuro: '#343434',
                cinzaClaro: '#808080'
            },
            branca: {
                normal: '#FFFFFF'
            },
            laranja: {
                normal: '#ED9209'
            }
        },
        estiloFontes: {
            Arial:'Arial'
        },
        fontSizes: {
            xs: 12,
            sm: 14,
            md: 16,
            lg: 20,
            xl: 24
        },
        shadow: {
            shadowColor: 'black',
            shadowOffset: { width: 0, height: 4 },
            shadowOpacity: 0.09,
            shadowRadius: 4,
        }
    }
)