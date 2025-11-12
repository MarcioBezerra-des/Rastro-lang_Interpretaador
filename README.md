# Rastro Lang - Interpretador# Rastro Lang - Interpretador



![Java](https://img.shields.io/badge/Java-8+-orange.svg)![Java](https://img.shields.io/badge/Java-8+-orange.svg)

![License](https://img.shields.io/badge/license-MIT-blue.svg)

## 📝 Visão Geral

## 📝 Visão Geral

**Rastro Lang** é uma linguagem de programação educacional baseada em comandos para controlar um robô virtual que desenha rastros em uma grade 2D. O projeto implementa um interpretador completo com análise léxica, sintática e execução de comandos.

**Rastro Lang** é uma linguagem de programação educacional baseada em comandos para controlar um robô virtual que desenha rastros em uma grade 2D. O projeto implementa um interpretador completo com análise léxica, sintática e execução de comandos.

O robô se move em uma grade 50x50 e pode deixar rastros marcados com `*` quando a caneta está abaixada. Ideal para ensino de conceitos de compiladores e interpretadores.

O robô se move em uma grade 50x50 e pode deixar rastros marcados com `*` quando a caneta está abaixada. Ideal para ensino de conceitos de compiladores e interpretadores.

## ✨ Funcionalidades

## 📂 Estrutura do Repositório

- **Controle de Caneta**: Liga/desliga o desenho do rastro

```- **Movimentação**: 4 direções (FRENTE, CIMA, DIREITA, ESQUERDA)

Rastro-lang_Interpretaador/- **Repetição**: Estruturas de loop com blocos

├── projeto/              # Código fonte do interpretador- **Comentários**: Suporte a comentários de linha com `//`

│   ├── src/             # Arquivos fonte Java- **Grid Visual**: Visualização ASCII 50x50 do trajeto do robô

│   ├── bin/             # Arquivos compilados

│   ├── lib/             # Dependências## 🛠️ Stack Técnica

│   ├── .vscode/         # Configurações VS Code

│   └── *.rastro         # Exemplos de programas### Linguagem

├── doc/                 # Documentação do projeto- **Java 8+** (compatível até Java 17+)

└── README.md           # Este arquivo

```### Arquitetura do Interpretador

- **Análise Léxica** (Scanner/Lexer)

## ✨ Funcionalidades- **Análise Sintática** (Parser Descendente Recursivo)

- **AST** (Abstract Syntax Tree)

- **Controle de Caneta**: Liga/desliga o desenho do rastro- **Interpretador** (Tree-Walking Interpreter)

- **Movimentação**: 4 direções (FRENTE, CIMA, DIREITA, ESQUERDA)

- **Repetição**: Estruturas de loop com blocos### Componentes Principais

- **Comentários**: Suporte a comentários de linha com `//`

- **Grid Visual**: Visualização ASCII 50x50 do trajeto do robô| Componente | Descrição |

|------------|-----------|

## 🛠️ Stack Técnica| `TipoToken.java` | Enum com todos os tokens da linguagem |

| `Token.java` | Representação de token (tipo, lexema, literal) |

### Linguagem| `AnalisadorLexico.java` | Tokenizador que converte código fonte em tokens |

- **Java 8+** (compatível até Java 17+)| `AnalisadorSintatico.java` | Parser que gera a AST |

| `Comando.java` | Interface para nós da AST |

### Arquitetura do Interpretador| `ComandoMover.java` | Nó AST para comando MOVER |

- **Análise Léxica** (Scanner/Lexer)| `ComandoCaneta.java` | Nó AST para comando CANETA |

- **Análise Sintática** (Parser Descendente Recursivo)| `ComandoRepetir.java` | Nó AST para comando REPETIR |

- **AST** (Abstract Syntax Tree)| `Robo.java` | Estado do robô (posição x,y e caneta) |

- **Interpretador** (Tree-Walking Interpreter)| `Grid.java` | Grade 50x50 para renderização |

| `Interpretador.java` | Executor da AST |

### Componentes Principais| `Compilador.java` | Ponto de entrada (main) |



| Componente | Descrição |## 📖 Como Funciona

|------------|-----------|

| `TipoToken.java` | Enum com todos os tokens da linguagem |### 1. Análise Léxica

| `Token.java` | Representação de token (tipo, lexema, literal) |O `AnalisadorLexico` lê o código fonte caractere por caractere e gera uma lista de tokens:

| `AnalisadorLexico.java` | Tokenizador que converte código fonte em tokens |- Identifica palavras-chave (CANETA, MOVER, REPETIR, etc.)

| `AnalisadorSintatico.java` | Parser que gera a AST |- Reconhece números inteiros

| `Comando.java` | Interface para nós da AST |- Identifica símbolos (`{`, `}`)

| `ComandoMover.java` | Nó AST para comando MOVER |- Ignora comentários (`//`) e espaços em branco

| `ComandoCaneta.java` | Nó AST para comando CANETA |

| `ComandoRepetir.java` | Nó AST para comando REPETIR |### 2. Análise Sintática

| `Robo.java` | Estado do robô (posição x,y e caneta) |O `AnalisadorSintatico` usa os tokens para construir uma AST seguindo a gramática:

| `Grid.java` | Grade 50x50 para renderização |```

| `Interpretador.java` | Executor da AST |programa   → comando*

| `Compilador.java` | Ponto de entrada (main) |comando    → cmd_mover | cmd_caneta | cmd_repetir

cmd_mover  → 'MOVER' direcao 'NUMERO'

## 📖 Como Funcionacmd_caneta → 'CANETA' ('CIMA' | 'BAIXO')

cmd_repetir → 'REPETIR' 'NUMERO' '{' programa '}'

### 1. Análise Léxicadirecao    → 'FRENTE' | 'DIREITA' | 'ESQUERDA' | 'CIMA'

O `AnalisadorLexico` lê o código fonte caractere por caractere e gera uma lista de tokens:```

- Identifica palavras-chave (CANETA, MOVER, REPETIR, etc.)

- Reconhece números inteiros### 3. Interpretação

- Identifica símbolos (`{`, `}`)O `Interpretador` percorre a AST e executa cada comando:

- Ignora comentários (`//`) e espaços em branco- Atualiza a posição do robô

- Controla o estado da caneta

### 2. Análise Sintática- Desenha na grade quando a caneta está abaixada

O `AnalisadorSintatico` usa os tokens para construir uma AST seguindo a gramática:- Exibe a grade final no console

```

programa   → comando*## 🚀 Como Executar

comando    → cmd_mover | cmd_caneta | cmd_repetir

cmd_mover  → 'MOVER' direcao 'NUMERO'### Pré-requisitos

cmd_caneta → 'CANETA' ('CIMA' | 'BAIXO')- Java JDK 8 ou superior

cmd_repetir → 'REPETIR' 'NUMERO' '{' programa '}'- Terminal/PowerShell

direcao    → 'FRENTE' | 'DIREITA' | 'ESQUERDA' | 'CIMA'

```### Compilar o Projeto



### 3. Interpretação```bash

O `Interpretador` percorre a AST e executa cada comando:# No diretório raiz do projeto

- Atualiza a posição do robôjavac -source 8 -target 8 -d bin src\*.java

- Controla o estado da caneta```

- Desenha na grade quando a caneta está abaixada

- Exibe a grade final no console### Executar um Programa



## 🚀 Como Executar```bash

java -cp bin Compilador arquivo.rastro

### Pré-requisitos```

- Java JDK 8 ou superior

- Terminal/PowerShell### Exemplo de Programa



### Compilar o ProjetoCrie um arquivo `exemplo.rastro`:



```bash```rastro

# No diretório projeto/// Desenha um quadrado

cd projetoCANETA BAIXO

javac -source 8 -target 8 -d bin src\*.javaREPETIR 4 {

```    MOVER FRENTE 5

    MOVER DIREITA 1

### Executar um Programa}



```bash// Move sem desenhar

# No diretório projeto/CANETA CIMA

java -cp bin Compilador arquivo.rastroMOVER DIREITA 3

```

// Desenha linha vertical

### Exemplo de ProgramaCANETA BAIXO

MOVER FRENTE 3

Crie um arquivo `exemplo.rastro`:```



```rastroExecute:

// Desenha um quadrado```bash

CANETA BAIXOjava -cp bin Compilador exemplo.rastro

REPETIR 4 {```

    MOVER FRENTE 5

    MOVER DIREITA 1## 📚 Sintaxe da Linguagem

}

### Comandos Disponíveis

// Move sem desenhar

CANETA CIMA#### CANETA

MOVER DIREITA 3Controla se o robô desenha ou não enquanto se move.

```rastro

// Desenha linha verticalCANETA BAIXO  // Ativa o desenho

CANETA BAIXOCANETA CIMA   // Desativa o desenho

MOVER FRENTE 3```

```

#### MOVER

Execute:Move o robô em uma direção por N passos.

```bash```rastro

java -cp bin Compilador exemplo.rastroMOVER FRENTE 5     // Move para frente 5 posições

```MOVER DIREITA 3    // Move para direita 3 posições

MOVER ESQUERDA 2   // Move para esquerda 2 posições

## 📚 Sintaxe da LinguagemMOVER CIMA 4       // Move para cima 4 posições

```

### Comandos Disponíveis

#### REPETIR

#### CANETAExecuta um bloco de comandos N vezes.

Controla se o robô desenha ou não enquanto se move.```rastro

```rastroREPETIR 3 {

CANETA BAIXO  // Ativa o desenho    MOVER FRENTE 2

CANETA CIMA   // Desativa o desenho    MOVER DIREITA 2

```}

```

#### MOVER

Move o robô em uma direção por N passos.#### Comentários

```rastro```rastro

MOVER FRENTE 5     // Move para frente 5 posições// Isto é um comentário de linha

MOVER DIREITA 3    // Move para direita 3 posições```

MOVER ESQUERDA 2   // Move para esquerda 2 posições

MOVER CIMA 4       // Move para cima 4 posições## 📁 Estrutura do Projeto

```

```

#### REPETIRRastro-lang_Interpretaador/

Executa um bloco de comandos N vezes.├── src/

```rastro│   ├── TipoToken.java           # Enum de tokens

REPETIR 3 {│   ├── Token.java               # Classe Token

    MOVER FRENTE 2│   ├── AnalisadorLexico.java    # Lexer

    MOVER DIREITA 2│   ├── AnalisadorSintatico.java # Parser

}│   ├── Comando.java             # Interface AST

```│   ├── ComandoMover.java        # AST MOVER

│   ├── ComandoCaneta.java       # AST CANETA

#### Comentários│   ├── ComandoRepetir.java      # AST REPETIR

```rastro│   ├── Robo.java                # Estado do robô

// Isto é um comentário de linha│   ├── Grid.java                # Grade de desenho

```│   ├── Interpretador.java       # Executor

│   └── Compilador.java          # Entry point

## 🎯 Exemplos de Uso├── bin/                          # Arquivos compilados

├── lib/                          # Dependências (vazio)

### Exemplo 1: Linha Simples├── teste.rastro                  # Exemplo de teste

```rastro├── quadrado.rastro               # Exemplo quadrado

CANETA BAIXO├── exemplo_completo.rastro       # Exemplo completo

MOVER FRENTE 10└── README.md                     # Este arquivo

``````



### Exemplo 2: Quadrado## 🎯 Exemplos de Uso

```rastro

CANETA BAIXO### Exemplo 1: Linha Simples

REPETIR 4 {```rastro

    MOVER FRENTE 5CANETA BAIXO

    MOVER DIREITA 5MOVER FRENTE 10

    MOVER CIMA 5```

    MOVER ESQUERDA 5

}### Exemplo 2: Quadrado

``````rastro

CANETA BAIXO

### Exemplo 3: EscadaREPETIR 4 {

```rastro    MOVER FRENTE 5

CANETA BAIXO    MOVER DIREITA 5

REPETIR 5 {    MOVER CIMA 5

    MOVER FRENTE 2    MOVER ESQUERDA 5

    MOVER DIREITA 2}

}```

```

### Exemplo 3: Escada

## 🧪 Testes```rastro

CANETA BAIXO

Os arquivos de teste estão incluídos no diretório `projeto/`:REPETIR 5 {

- `arquivo.rastro` - Teste básico de movimentação    MOVER FRENTE 2

- `quadrado.rastro` - Desenha forma quadrada    MOVER DIREITA 2

- `exemplo_completo.rastro` - Exemplo com múltiplos comandos e comentários}

```

Execute qualquer teste:

```bash## 🧪 Testes

cd projeto

java -cp bin Compilador arquivo.rastroOs arquivos de teste estão incluídos:

```- `arquivo.rastro` - Teste básico de movimentação

- `quadrado.rastro` - Desenha forma quadrada

## 📖 Documentação- `exemplo_completo.rastro` - Exemplo com múltiplos comandos e comentários



Para mais detalhes técnicos, consulte a pasta `doc/` que contém:Execute qualquer teste:

- Especificação completa da linguagem```bash

- Diagramas de arquiteturajava -cp bin Compilador arquivo.rastro

- Guias de desenvolvimento```

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se livre para:
1. Fazer fork do projeto
2. Criar uma branch para sua feature (`git checkout -b feature/NovaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/NovaFeature`)
5. Abrir um Pull Request

## 📝 Licença

Este projeto é licenciado sob a MIT License.

## 👨‍💻 Autor

Desenvolvido como projeto educacional para demonstrar conceitos de compiladores e interpretadores.

---

**Rastro Lang** - Aprendendo compiladores de forma visual e divertida! 🎨🤖
