## Android MVVM + Retrofit + Coroutines

Fala Droids!

Hoje vamos falar sobre requisições HTTP no Android usando a popular lib Retrofit junto com as poderosas Coroutines do Kotlin.

O objetivo do projeto é mostrar uma lista com nomes de países em uma RecyclerView simples.

O projeto será construído da seguinte forma:

1. Retrofit para fazer requisições HTTP para uma API pública 
2. Coroutines (Threads leves) para gerenciar a chamada assíncrona dessa requisição HTTP e definir em quais threads devem ser executadas
3. ViewModel para separar a gerencia de estado e busca de informação da nossa UI
4. LiveData para atualizar de forma reativa as informações na tela 

A layer ViewModel utilizará o Architecture Component ViewModel,  que vai gerenciar o tempo de vida da nossa ViewModel através das mudanças do ciclo de vida da Activity através da injeção usando o provider que ela traz.

#### Artigo Medium
https://medium.com/@tguizelini/android-mvvm-retrofit-coroutines-s2-7f09bce0ad0c