# Sistema Secretaria Acadêmica

# Integrantes: Ricardo, Guilherme

Projeto Java que demonstra a aplicação dos padrões de projeto **Singleton** e **Prototype** no contexto de emissão de certificados de conclusão de curso.

---

## Padrões de Projeto Utilizados

### 1. Singleton — `FilaDeImpressao`

**Problema:** A impressora central não pode receber conexões múltiplas simultâneas; documentos sairiam misturados ou a impressora travaria.

**Solução:** A classe [`FilaDeImpressao`](src/FilaDeImpressao.java) implementa o padrão Singleton garantindo que **apenas uma instância** seja criada durante toda a execução do programa.

**Como funciona:**
- O construtor é `private`, impedindo que qualquer outra classe use `new FilaDeImpressao()`.
- O atributo estático `instance` guarda a única referência existente.
- O método estático `getInstance()` cria o objeto na primeira chamada e, nas chamadas seguintes, devolve sempre o mesmo objeto já criado (*lazy initialization*).

```
FilaDeImpressao fila1 = FilaDeImpressao.getInstance();
FilaDeImpressao fila2 = FilaDeImpressao.getInstance();
// fila1 == fila2 → true (mesma referência na memória)
```

---

### 2. Prototype — `Certificado`

**Problema:** Carregar os dados de arte e curso do banco de dados a cada emissão é custoso. O ideal é carregar o template **uma única vez** e cloná-lo para cada aluno.

**Solução:** A classe [`Certificado`](src/Certificado.java) implementa o padrão Prototype por meio do método `clonar()`, que usa um construtor de cópia privado para criar uma nova instância independente com os mesmos dados do original.

**Como funciona:**
- `new Certificado(nomeCurso)` — cria o molde com o nome do curso; `nomeAluno` começa vazio.
- `clonar()` — retorna um novo `Certificado` copiando todos os atributos do original.
- `setNomeAluno(nome)` — personaliza cada clone com o nome do aluno.
- `getDados()` — retorna a string formatada do certificado para impressão.

```
Certificado original = new Certificado("ADS");
Certificado clone1   = original.clonar();
Certificado clone2   = original.clonar();
clone1.setNomeAluno("Ana Silva");
clone2.setNomeAluno("Bruno Costa");
// clone1 == clone2 → false (objetos independentes na memória)
```

---

## Estrutura do Projeto

```
secretaria-academica/
└── src/
    ├── FilaDeImpressao.java   # Padrão Singleton
    ├── Certificado.java       # Padrão Prototype
    └── Main.java              # Classe principal com o roteiro completo
```

---

## Como Executar

### Pré-requisito
- Java JDK 8 ou superior instalado.

### Compilar
```bash
cd src
javac FilaDeImpressao.java Certificado.java Main.java
```

### Executar
```bash
java Main
```

### Saída esperada

```
=== 1. Obtendo instância da FilaDeImpressao ===
[FilaDeImpressao] Conexão com a impressora central estabelecida.
fila == fila2 (Singleton): true

=== 2. Criando certificado original (molde) ===
[Certificado] Certificado padrão criado para o curso: Análise e Desenvolvimento de Sistemas

=== 3. Clonando o certificado ===

=== 4. Personalizando os clones ===

=== 5. Enviando certificados para impressão ===
[FilaDeImpressao] Imprimindo: Curso: Análise e Desenvolvimento de Sistemas | Aluno: Ana Silva
[FilaDeImpressao] Imprimindo: Curso: Análise e Desenvolvimento de Sistemas | Aluno: Bruno Costa

=== 6. Teste de memória (Prototype) ===
clone1 == clone2: false
```

---

## Roteiro da Main

| Passo | Ação | Padrão |
|-------|------|--------|
| 1 | Solicita a instância única de `FilaDeImpressao` via `getInstance()` | Singleton |
| 2 | Cria o certificado original com `new Certificado(nomeCurso)` — aluno em branco | Prototype (molde) |
| 3 | Chama `clonar()` duas vezes para gerar dois certificados independentes | Prototype (clonagem) |
| 4 | Usa `setNomeAluno()` para personalizar cada clone | — |
| 5 | Envia `getDados()` de cada clone para `fila.imprimir()` | Singleton |
| 6 | Imprime `clone1 == clone2` para provar que são objetos distintos na memória | Prototype (validação) |

---

## Validações

- **Singleton:** `fila == fila2` → `true` — a mesma referência é retornada nas duas chamadas a `getInstance()`.
- **Prototype:** `clone1 == clone2` → `false` — cada clone ocupa um endereço diferente na memória, provando que são objetos independentes.
