const sessoes = [
    {
        id: 1,
        titulo: 'Insira suas informações',
        entradaTexto: [
            {
                id: 1,
                icon: 'person',
                placeholder: 'Nome'
            },
            {
                id: 2,
                icon: 'mail',
                placeholder: 'E-mail'
            },
            {
                id: 3,
                icon: 'call',
                placeholder: 'Telefone'
            }
        ]
    },
    {
        id: 2,
        titulo: 'Seu endereço',
        entradaTexto: [
            {
                id: 1,
                icon: 'home',
                placeholder: 'Logradouro'
            },
            {
                id: 2,
                icon: 'map',
                placeholder: 'Bairro'
            },
            {
                id: 3,
                icon: 'business',
                placeholder: 'Cidade'
            },
            {
                id: 4,
                icon: 'pin',
                placeholder: 'Número'
            },
            {
                id: 5,
                icon: 'add-circle-outline',
                placeholder: 'Complemento'
            },
            {
                id: 6,
                icon: 'location',
                placeholder: 'CEP'
            },
            {
                id: 7,
                icon: 'globe',
                placeholder: 'UF'
            },

        ]
    },
    {
        id: 3,
        titulo: 'Informações de Usuário',
        entradaTexto: [
            {
                id: 1,
                icon: 'person',
                placeholder: 'Login'
            },
            {
                id: 2,
                placeholder: 'Senha',
                senha: true
            },
            {
                id: 3,
                placeholder: 'Repita Sua Senha',
                senha: true
            }
        ]
    }

]

export { sessoes }