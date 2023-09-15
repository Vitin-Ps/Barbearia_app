import { useState } from "react";

  
  
  export const EstadoClick = (setIsLoading) => {

    setIsLoading(true); // quando eu clico vai pra true
    setTimeout(() => {
      setIsLoading(false); // depois de 2000 milessegundos ele volta pra false
    }, 2000);
  };
