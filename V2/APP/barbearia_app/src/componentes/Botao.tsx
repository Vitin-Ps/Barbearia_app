import { Button, ITextProps } from 'native-base';
import { TEMAS } from '../estilos/tema';

interface TextoProps extends ITextProps {
  children: React.ReactNode;
  isLoading?: boolean;
}

const Botao = ({ children, isLoading, ...rest }: TextoProps) => {
  

  let backgroundColor = TEMAS.colors.marrom.normal;

  if (isLoading) {
    backgroundColor = TEMAS.colors.marrom.normalClaro;
  }
  

  return (
    <Button
      w="40%"
      p={3}
      bg={backgroundColor}
      m={5}
      mt={10}
      mb={5}
     
      borderRadius="lg"
      isLoading={isLoading}
      {...rest}
    >
      {children}
    </Button>
  );
};

export default Botao;
