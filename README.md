Curupira's Rage: Welcome to the Jungle!
=======================================

Um jogo simples de android onde o jogador deve acabar com os caçadores na pele do
lendário Curupira!


Obtendo o Projeto
-----------------

Clone o repositório:

    git clone git@github.com:arruda/curupirasrage.git

execute o script para preparar o projeto:

    ./gerar_projeto_eclipse.sh

Ou no **windows** de dois cliques em **gerar_projeto_eclipse.bat**

No eclipse android, mande importar o projeto a partir do repositório clonado, normalmente.


Resolvendo problemas
--------------------

Provavelmente você ao importar o projeto terá o seguinte problema:

    Android AAPT problem

Se esse for o caso faça o seguinte:

* Clique com botão direito no projeto, e vá em **properties**
* Selecione a categoria **Android**
* na caixa de **Library** remova a referencia para o projeto appcompat_v4(provavelmente com um X vermelho na frente)
* clique em Add e selecione o projto app_compat_v4 do seu workspace (**veja OBS abaixo**)
* Se der problema "Jar mismatch!..." remova o arquivo **libs/android-support-v4.jar** de seu projeto **app_compat_v4** e tudo deverá funcionar.

**OBS**: se não possuir o projeto em seu workspace veja como acha-lo aqui(na parte **Using Eclipse**) https://developer.android.com/tools/support-library/setup.html#libs-with-res


REFERENCIAS
-----------



LICENÇA
=======

Esse projeto é feito sob a licença MIT, veja o arquivo LICENSE para mais detalhes.