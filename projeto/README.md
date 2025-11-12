# Projeto Rastro Lang

Este diretório contém o código fonte do interpretador Rastro Lang.

## Estrutura

```
projeto/
├── src/                  # Código fonte Java
│   ├── TipoToken.java
│   ├── Token.java
│   ├── AnalisadorLexico.java
│   ├── AnalisadorSintatico.java
│   ├── Comando.java
│   ├── ComandoMover.java
│   ├── ComandoCaneta.java
│   ├── ComandoRepetir.java
│   ├── Robo.java
│   ├── Grid.java
│   ├── Interpretador.java
│   └── Compilador.java
├── bin/                  # Arquivos compilados (.class)
├── lib/                  # Bibliotecas externas
├── .vscode/              # Configurações do VS Code
└── *.rastro              # Exemplos de programas

```

## Compilar

```bash
javac -source 8 -target 8 -d bin src\*.java
```

## Executar

```bash
java -cp bin Compilador arquivo.rastro
```

## Exemplos Incluídos

- `arquivo.rastro` - Teste básico
- `quadrado.rastro` - Desenha quadrado
- `exemplo_completo.rastro` - Exemplo com comentários
