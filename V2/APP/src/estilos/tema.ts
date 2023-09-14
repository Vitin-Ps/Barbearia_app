import { extendTheme } from "native-base"

export const TEMAS = extendTheme(
    {
        colors: {
            marrom: {
                normal: '#B08E51'
            },
            cinza: {
                cinzaBlack: '#202020',
                cinzaEscuro: '#343434'
            },
            branca: {
                normal: '#FFFFFF'
            },
            laranja: {
                normal: '#ED9209'
            }
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