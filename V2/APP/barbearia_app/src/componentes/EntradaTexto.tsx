import { Icon, Input } from "native-base";
import Ionicons from "react-native-vector-icons/Ionicons"
import { TEMAS } from "../estilos/tema";

interface InputProps { // descreve pro´ridades que podem estár no entrada texto
    icon?: string,
    color?: string
    placeholder: string;
}


// const [show, setShow] = useState(false);

export function EntradaTexto({
    icon,
    color,
    placeholder
}: InputProps): JSX.Element {
    return (
        // <Stack space={4} w="100%" alignItems="center">
            <Input
                mt={5}
                fontSize='20px'
                fontWeight='400'
                width="100%"
                bgColor={TEMAS.colors.cinza.cinzaEscuro}
                color='white'
                shadow={3}
                InputLeftElement={
                    <Icon
                        as={<Ionicons name={icon} />}
                        color={color}
                        size={6}
                        marginLeft={2}
                    />
                }
                placeholder={placeholder}
            />
    )
}


























// import { Icon, Input, Stack } from "native-base";
// import { useState } from "react";
// import { Pressable } from "react-native";
// import Ionicons from "react-native-vector-icons/Ionicons"
// import { TEMAS } from "../estilos/tema";

// interface InputProps { // descreve pro´ridades que podem estár no entrada texto
//     icon?: string,
//     color?: string
//     label?: string;
//     sizeIcon?: string
//     placeholder: string;
//     secureTextEntry?: boolean;
//     value?: string;
//     onChangeText?: (text: string) => void; // chamada para alguma alteralção de texto
// }


// // const [show, setShow] = useState(false);

// export function EntradaTexto({
//     icon,
//     color,
//     placeholder
// }: InputProps) :JSX.Element {
//     return (
//         // <Stack space={4} w="100%" alignItems="center">
//             <Input
//                 mt={5}
//                 fontSize='20px'
//                 fontWeight='400'
//                 width="100%"
//                 bgColor={TEMAS.colors.cinza.cinzaEscuro}
//                 color='white'
//                 shadow={3}
//                 InputLeftElement={
//                     <Icon
//                         as={<Ionicons name={icon} />}
//                         color={color}
//                         size={6}
//                         marginLeft={2}
//                     />
//                 }
//                 placeholder={placeholder}
//             />
//     )
// }






