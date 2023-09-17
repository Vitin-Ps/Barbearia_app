const sessoes = [
    {
        id: 1,
        titulo: 'Insira suas informações',
        entradaTexto: [
            {
                id: 1,
                icon: 'person',
                placeholder: 'Nome',
                name: 'nome'
            },
            {
                id: 2,
                icon: 'mail',
                placeholder: 'E-mail',
                name: 'email'
            },
            {
                id: 3,
                icon: 'call',
                placeholder: 'Telefone',
                name: 'telefone'
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
                placeholder: 'Logradouro',
                name: 'logradouro'
            },
            {
                id: 2,
                icon: 'map',
                placeholder: 'Bairro',
                name: 'bairro'
            },
            {
                id: 3,
                icon: 'business',
                placeholder: 'Cidade',
                name: 'cidade'
            },
            {
                id: 4,
                icon: 'pin',
                placeholder: 'Número',
                name: 'numero'
            },
            {
                id: 5,
                icon: 'add-circle-outline',
                placeholder: 'Complemento',
                name: 'complemento'
            },
            {
                id: 6,
                icon: 'location',
                placeholder: 'CEP',
                name: 'cep'
            },
            {
                id: 7,
                icon: 'globe',
                placeholder: 'UF',
                name: 'uf'
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
                placeholder: 'Login',
                name: 'login'
            },
            {
                id: 2,
                placeholder: 'Senha',
                senha: true,
                name: 'senha'
            },
            {
                id: 3,
                placeholder: 'Repita Sua Senha',
                senha: true,
                name: 'confirmaSenha'
            }
        ]
    }

]

export { sessoes }