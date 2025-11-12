# Rastro Lang - Interpretador# Rastro Lang - Interpretador# Rastro Lang - Interpretador



![Java](https://img.shields.io/badge/Java-8+-orange.svg)

![License](https://img.shields.io/badge/license-MIT-blue.svg)

![Java](https://img.shields.io/badge/Java-8+-orange.svg)![Java](https://img.shields.io/badge/Java-8+-orange.svg)

## 📝 Visão Geral

![License](https://img.shields.io/badge/license-MIT-blue.svg)

**Rastro Lang** é uma linguagem de programação educacional baseada em comandos para controlar um robô virtual que desenha rastros em uma grade 2D. O projeto implementa um interpretador completo com análise léxica, sintática e execução de comandos.

## 📝 Visão Geral

O robô se move em uma grade 50x50 e pode deixar rastros marcados com `*` quando a caneta está abaixada. Ideal para ensino de conceitos de compiladores e interpretadores.

## 📝 Visão Geral

## 📂 Estrutura do Repositório

**Rastro Lang** é uma linguagem de programação educacional baseada em comandos para controlar um robô virtual que desenha rastros em uma grade 2D. O projeto implementa um interpretador completo com análise léxica, sintática e execução de comandos.

```

Rastro-lang_Interpretaador/**Rastro Lang** é uma linguagem de programação educacional baseada em comandos para controlar um robô virtual que desenha rastros em uma grade 2D. O projeto implementa um interpretador completo com análise léxica, sintática e execução de comandos.

├── projeto/              # Código fonte do interpretador

│   ├── src/             # Arquivos fonte JavaO robô se move em uma grade 50x50 e pode deixar rastros marcados com `*` quando a caneta está abaixada. Ideal para ensino de conceitos de compiladores e interpretadores.

│   ├── bin/             # Arquivos compilados

│   ├── lib/             # DependênciasO robô se move em uma grade 50x50 e pode deixar rastros marcados com `*` quando a caneta está abaixada. Ideal para ensino de conceitos de compiladores e interpretadores.

│   ├── .vscode/         # Configurações VS Code

│   └── *.rastro         # Exemplos de programas## ✨ Funcionalidades

├── doc/                 # Documentação do projeto

└── README.md           # Este arquivo## 📂 Estrutura do Repositório

```

- **Controle de Caneta**: Liga/desliga o desenho do rastro

## ✨ Funcionalidades

```- **Movimentação**: 4 direções (FRENTE, CIMA, DIREITA, ESQUERDA)

- **Controle de Caneta**: Liga/desliga o desenho do rastro

- **Movimentação**: 4 direções (FRENTE, CIMA, DIREITA, ESQUERDA)Rastro-lang_Interpretaador/- **Repetição**: Estruturas de loop com blocos

- **Repetição**: Estruturas de loop com blocos

- **Comentários**: Suporte a comentários de linha com `//`├── projeto/              # Código fonte do interpretador- **Comentários**: Suporte a comentários de linha com `//`

- **Grid Visual**: Visualização ASCII 50x50 do trajeto do robô

│   ├── src/             # Arquivos fonte Java- **Grid Visual**: Visualização ASCII 50x50 do trajeto do robô

## 🛠️ Stack Técnica

│   ├── bin/             # Arquivos compilados

### Linguagem

- **Java 8+** (compatível até Java 17+)│   ├── lib/             # Dependências## 🛠️ Stack Técnica



### Arquitetura do Interpretador│   ├── .vscode/         # Configurações VS Code

- **Análise Léxica** (Scanner/Lexer)

- **Análise Sintática** (Parser Descendente Recursivo)│   └── *.rastro         # Exemplos de programas### Linguagem

- **AST** (Abstract Syntax Tree)

- **Interpretador** (Tree-Walking Interpreter)├── doc/                 # Documentação do projeto- **Java 8+** (compatível até Java 17+)



### Componentes Principais└── README.md           # Este arquivo



| Componente | Descrição |```### Arquitetura do Interpretador

|------------|-----------|

| `TipoToken.java` | Enum com todos os tokens da linguagem |- **Análise Léxica** (Scanner/Lexer)

| `Token.java` | Representação de token (tipo, lexema, literal) |

| `AnalisadorLexico.java` | Tokenizador que converte código fonte em tokens |## ✨ Funcionalidades- **Análise Sintática** (Parser Descendente Recursivo)

| `AnalisadorSintatico.java` | Parser que gera a AST |

| `Comando.java` | Interface para nós da AST |- **AST** (Abstract Syntax Tree)

| `ComandoMover.java` | Nó AST para comando MOVER |

| `ComandoCaneta.java` | Nó AST para comando CANETA |- **Controle de Caneta**: Liga/desliga o desenho do rastro- **Interpretador** (Tree-Walking Interpreter)

| `ComandoRepetir.java` | Nó AST para comando REPETIR |

| `Robo.java` | Estado do robô (posição x,y e caneta) |- **Movimentação**: 4 direções (FRENTE, CIMA, DIREITA, ESQUERDA)

| `Grid.java` | Grade 50x50 para renderização |

| `Interpretador.java` | Executor da AST |- **Repetição**: Estruturas de loop com blocos### Componentes Principais

| `Compilador.java` | Ponto de entrada (main) |

- **Comentários**: Suporte a comentários de linha com `//`

## 📖 Como Funciona

- **Grid Visual**: Visualização ASCII 50x50 do trajeto do robô| Componente | Descrição |

### 1. Análise Léxica

O `AnalisadorLexico` lê o código fonte caractere por caractere e gera uma lista de tokens:|------------|-----------|

- Identifica palavras-chave (CANETA, MOVER, REPETIR, etc.)

- Reconhece números inteiros## 🛠️ Stack Técnica| `TipoToken.java` | Enum com todos os tokens da linguagem |

- Identifica símbolos (`{`, `}`)

- Ignora comentários (`//`) e espaços em branco| `Token.java` | Representação de token (tipo, lexema, literal) |



### 2. Análise Sintática### Linguagem| `AnalisadorLexico.java` | Tokenizador que converte código fonte em tokens |

O `AnalisadorSintatico` usa os tokens para construir uma AST seguindo a gramática:

```- **Java 8+** (compatível até Java 17+)| `AnalisadorSintatico.java` | Parser que gera a AST |

programa   → comando*

comando    → cmd_mover | cmd_caneta | cmd_repetir| `Comando.java` | Interface para nós da AST |

cmd_mover  → 'MOVER' direcao 'NUMERO'

cmd_caneta → 'CANETA' ('CIMA' | 'BAIXO')### Arquitetura do Interpretador| `ComandoMover.java` | Nó AST para comando MOVER |

cmd_repetir → 'REPETIR' 'NUMERO' '{' programa '}'

direcao    → 'FRENTE' | 'DIREITA' | 'ESQUERDA' | 'CIMA'- **Análise Léxica** (Scanner/Lexer)| `ComandoCaneta.java` | Nó AST para comando CANETA |

```

- **Análise Sintática** (Parser Descendente Recursivo)| `ComandoRepetir.java` | Nó AST para comando REPETIR |

### 3. Interpretação

O `Interpretador` percorre a AST e executa cada comando:- **AST** (Abstract Syntax Tree)| `Robo.java` | Estado do robô (posição x,y e caneta) |

- Atualiza a posição do robô

- Controla o estado da caneta- **Interpretador** (Tree-Walking Interpreter)| `Grid.java` | Grade 50x50 para renderização |

- Desenha na grade quando a caneta está abaixada

- Exibe a grade final no console| `Interpretador.java` | Executor da AST |



## 🚀 Como Executar### Componentes Principais| `Compilador.java` | Ponto de entrada (main) |



### Pré-requisitos

- Java JDK 8 ou superior

- Terminal/PowerShell| Componente | Descrição |## 📖 Como Funciona



### Compilar o Projeto|------------|-----------|



```bash| `TipoToken.java` | Enum com todos os tokens da linguagem |### 1. Análise Léxica

# No diretório projeto/

cd projeto| `Token.java` | Representação de token (tipo, lexema, literal) |O `AnalisadorLexico` lê o código fonte caractere por caractere e gera uma lista de tokens:

javac -source 8 -target 8 -d bin src\*.java

```| `AnalisadorLexico.java` | Tokenizador que converte código fonte em tokens |- Identifica palavras-chave (CANETA, MOVER, REPETIR, etc.)



### Executar um Programa| `AnalisadorSintatico.java` | Parser que gera a AST |- Reconhece números inteiros



```bash| `Comando.java` | Interface para nós da AST |- Identifica símbolos (`{`, `}`)

# No diretório projeto/

java -cp bin Compilador arquivo.rastro| `ComandoMover.java` | Nó AST para comando MOVER |- Ignora comentários (`//`) e espaços em branco

```

| `ComandoCaneta.java` | Nó AST para comando CANETA |

### Exemplo de Programa

| `ComandoRepetir.java` | Nó AST para comando REPETIR |### 2. Análise Sintática

Crie um arquivo `exemplo.rastro`:

| `Robo.java` | Estado do robô (posição x,y e caneta) |O `AnalisadorSintatico` usa os tokens para construir uma AST seguindo a gramática:

```rastro

// Desenha um quadrado| `Grid.java` | Grade 50x50 para renderização |```

CANETA BAIXO

REPETIR 4 {| `Interpretador.java` | Executor da AST |programa   → comando*

    MOVER FRENTE 5

    MOVER DIREITA 1| `Compilador.java` | Ponto de entrada (main) |comando    → cmd_mover | cmd_caneta | cmd_repetir

}

cmd_mover  → 'MOVER' direcao 'NUMERO'

// Move sem desenhar

CANETA CIMA## 📖 Como Funcionacmd_caneta → 'CANETA' ('CIMA' | 'BAIXO')

MOVER DIREITA 3

cmd_repetir → 'REPETIR' 'NUMERO' '{' programa '}'

// Desenha linha vertical

CANETA BAIXO### 1. Análise Léxicadirecao    → 'FRENTE' | 'DIREITA' | 'ESQUERDA' | 'CIMA'

MOVER FRENTE 3

```O `AnalisadorLexico` lê o código fonte caractere por caractere e gera uma lista de tokens:```



Execute:- Identifica palavras-chave (CANETA, MOVER, REPETIR, etc.)

```bash

java -cp bin Compilador exemplo.rastro- Reconhece números inteiros### 3. Interpretação

```

- Identifica símbolos (`{`, `}`)O `Interpretador` percorre a AST e executa cada comando:

## 📚 Sintaxe da Linguagem

- Ignora comentários (`//`) e espaços em branco- Atualiza a posição do robô

### Comandos Disponíveis

- Controla o estado da caneta

#### CANETA

Controla se o robô desenha ou não enquanto se move.### 2. Análise Sintática- Desenha na grade quando a caneta está abaixada

```rastro

CANETA BAIXO  // Ativa o desenhoO `AnalisadorSintatico` usa os tokens para construir uma AST seguindo a gramática:- Exibe a grade final no console

CANETA CIMA   // Desativa o desenho

``````



#### MOVERprograma   → comando*## 🚀 Como Executar

Move o robô em uma direção por N passos.

```rastrocomando    → cmd_mover | cmd_caneta | cmd_repetir

MOVER FRENTE 5     // Move para frente 5 posições

MOVER DIREITA 3    // Move para direita 3 posiçõescmd_mover  → 'MOVER' direcao 'NUMERO'### Pré-requisitos

MOVER ESQUERDA 2   // Move para esquerda 2 posições

MOVER CIMA 4       // Move para cima 4 posiçõescmd_caneta → 'CANETA' ('CIMA' | 'BAIXO')- Java JDK 8 ou superior

```

cmd_repetir → 'REPETIR' 'NUMERO' '{' programa '}'- Terminal/PowerShell

#### REPETIR

Executa um bloco de comandos N vezes.direcao    → 'FRENTE' | 'DIREITA' | 'ESQUERDA' | 'CIMA'

```rastro

REPETIR 3 {```### Compilar o Projeto

    MOVER FRENTE 2

    MOVER DIREITA 2

}

```### 3. Interpretação```bash



#### ComentáriosO `Interpretador` percorre a AST e executa cada comando:# No diretório raiz do projeto

```rastro

// Isto é um comentário de linha- Atualiza a posição do robôjavac -source 8 -target 8 -d bin src\*.java

```

- Controla o estado da caneta```

## 🎯 Exemplos de Uso

- Desenha na grade quando a caneta está abaixada

### Exemplo 1: Linha Simples

```rastro- Exibe a grade final no console### Executar um Programa

CANETA BAIXO

MOVER FRENTE 10

```

## 🚀 Como Executar```bash

### Exemplo 2: Quadrado

```rastrojava -cp bin Compilador arquivo.rastro

CANETA BAIXO

REPETIR 4 {### Pré-requisitos```

    MOVER FRENTE 5

    MOVER DIREITA 5- Java JDK 8 ou superior

    MOVER CIMA 5

    MOVER ESQUERDA 5- Terminal/PowerShell### Exemplo de Programa

}

```



### Exemplo 3: Escada### Compilar o ProjetoCrie um arquivo `exemplo.rastro`:

```rastro

CANETA BAIXO

REPETIR 5 {

    MOVER FRENTE 2```bash```rastro

    MOVER DIREITA 2

}# No diretório projeto/// Desenha um quadrado

```

cd projetoCANETA BAIXO

## 🧪 Testes

javac -source 8 -target 8 -d bin src\*.javaREPETIR 4 {

Os arquivos de teste estão incluídos no diretório `projeto/`:

- `arquivo.rastro` - Teste básico de movimentação```    MOVER FRENTE 5

- `quadrado.rastro` - Desenha forma quadrada

- `exemplo_completo.rastro` - Exemplo com múltiplos comandos e comentários    MOVER DIREITA 1



Execute qualquer teste:### Executar um Programa}

```bash

cd projeto

java -cp bin Compilador arquivo.rastro

``````bash// Move sem desenhar



## 📖 Documentação# No diretório projeto/CANETA CIMA



Para mais detalhes técnicos, consulte a pasta `doc/` que contém:java -cp bin Compilador arquivo.rastroMOVER DIREITA 3

- Especificação completa da linguagem

- Diagramas de arquitetura```

- Guias de desenvolvimento

// Desenha linha vertical

## 🤝 Contribuindo

### Exemplo de ProgramaCANETA BAIXO

Contribuições são bem-vindas! Sinta-se livre para:

1. Fazer fork do projetoMOVER FRENTE 3

2. Criar uma branch para sua feature (`git checkout -b feature/NovaFeature`)

3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)Crie um arquivo `exemplo.rastro`:```

4. Push para a branch (`git push origin feature/NovaFeature`)

5. Abrir um Pull Request



## 📝 Licença```rastroExecute:



Este projeto é licenciado sob a MIT License.// Desenha um quadrado```bash



## 👨‍💻 AutorCANETA BAIXOjava -cp bin Compilador exemplo.rastro



Desenvolvido como projeto educacional para demonstrar conceitos de compiladores e interpretadores.REPETIR 4 {```



---    MOVER FRENTE 5



**Rastro Lang** - Aprendendo compiladores de forma visual e divertida! 🎨🤖    MOVER DIREITA 1## 📚 Sintaxe da Linguagem


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
