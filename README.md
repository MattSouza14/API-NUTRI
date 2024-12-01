# Documentação da API para Aplicativo Móvel

## Base URL
A API está disponível nos seguintes domínios para permitir requisições cross-origin:
- `http://localhost:3000`
- `http://10.0.2.2:3000`

---

## Endpoints

### 1. Listar Usuários
**Descrição:** Retorna uma lista com todos os usuários cadastrados.

- **Método:** `GET`
- **URL:** `/listarUsuarios`
- **Resposta de Sucesso (200):**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "cpf": "123.456.789-00",
    "email": "joao@email.com",
    "telefone": "1234-5678",
    "senha": "senha123"
  },
  {
    "id": 2,
    "nome": "Maria Oliveira",
    "cpf": "987.654.321-00",
    "email": "maria@email.com",
    "telefone": "1234-5678",
    "senha": "senha456"
  }
]
```

---

### 2. Buscar Usuário por CPF
**Descrição:** Retorna as informações de um usuário com base no CPF fornecido.

- **Método:** `GET`
- **URL:** `/cpf/{cpf}`
- **Parâmetro de URL:**
  - `cpf` (String): CPF do usuário.
- **Resposta de Sucesso (200):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "cpf": "123.456.789-00",
  "email": "joao@email.com",
  "telefone": "1234-5678",
  "senha": "senha123"
}
```

---

### 3. Cadastrar Usuário
**Descrição:** Cadastra um novo usuário.

- **Método:** `POST`
- **URL:** `/cadastro`
- **Body (JSON):**
```json
{
  "nome": "João Silva",
  "cpf": "123.456.789-00",
  "email": "joao@email.com",
  "telefone": "1234-5678",
  "senha": "senha123"
}
```
- **Resposta de Sucesso (201):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "cpf": "123.456.789-00",
  "email": "joao@email.com",
  "telefone": "1234-5678",
  "senha": "senha123"
}
```

---

### 4. Deletar Usuário por CPF
**Descrição:** Deleta um usuário com base no CPF fornecido.

- **Método:** `DELETE`
- **URL:** `/cpf/{cpf}`
- **Parâmetro de URL:**
  - `cpf` (String): CPF do usuário.
- **Resposta de Sucesso (200):**
```json
"Usuário deletado com sucesso."
```
- **Resposta de Erro (404):**
```json
"Usuário não encontrado."
```

---

### 5. Atualizar Campos de um Paciente
**Descrição:** Atualiza informações específicas de um paciente com base no CPF fornecido.

- **Método:** `PATCH`
- **URL:** `/paciente/{cpf}`
- **Parâmetro de URL:**
  - `cpf` (String): CPF do paciente.
- **Body (JSON):**
```json
{
  "nome": "João Silva Atualizado",
  "email": "joao.atualizado@email.com"
}
```
- **Resposta de Sucesso (200):**
```json
"Dados do paciente atualizados com sucesso."
```
- **Resposta de Erro (404):**
```json
"Paciente não encontrado."
```

---

### 6. Login
**Descrição:** Realiza o login de um usuário com base no email e senha.

- **Método:** `POST`
- **URL:** `/login`
- **Body (JSON):**
```json
{
  "email": "joao@email.com",
  "senha": "senha123"
}
```
- **Resposta de Sucesso (200):**
```json
"Login realizado com sucesso!"
```
- **Resposta de Erro (401):**
```json
"Senha incorreta."
```
- **Resposta de Erro (404):**
```json
"Usuário não encontrado."
```

---

## Observações
- A API ainda está em construção.
- Futuramente serão adicionados endpoints para:
  - Cadastro, login e gerenciamento de dados para administradores.
  - Relatórios detalhados para os pacientes.

---
