# TesteQA
Teste para candidatos a vaga de QA
  Pre-requisitos:
    Android Studio (SDK)
    Appium 
    Java 
    IDE Java
    Maven
    TestNG
    app instalado através do PlayStore no mobile
  Como executar o projeto:
    Acessar o arquivo /desafio-qa-git/src/test/resources/project.properties
    Alterar a propriedade: env.android.capability.udid de acordo o mobile que será executado (usar o comando "adb devices" para capturar o ID do mobile) 
    Acessar o diretório do projeto, ir até a pasta lib
    Executar o comando mvn install
    Acessar o diretório raiz do projeto
    Executar o comando mvn test
  
