# Calculatrice évoluée

Bienvenue sur le répertoire du projet "Calculatrice évoluée" de Kévin DANG et Anthony Phothirath

## Objectif du projet (rappel du sujet)
Le sujet consiste à programmer une calculatrice. Un classique ?... pas tout à fait !
En effet, il ne s’agit pas d’une calculatrice simulant une calculatrice physique avec des boutons :
cela aurait peu d’intérêt par rapport à l’ergonomie qu’on peut avoir avec un clavier et un écran
d’ordinateur.
Il s’agit plutôt d’un shell, c’est-à-dire une boucle d’entrée/évaluation/affichage (REPL : read,
eval, print, loop).
Qui plus est, les extensions proposées feront de cette calculatrice un outil bien plus puissant que
la plupart des calculatrices (qu’elles soient physiques ou bien des applications pour ordinateur).

# Comment démarrer la calculatrice 

## Compilation

### Configuration requise

- `Java JDK (15)`
- `Gradle (6.7.1)`
- `Junit (4.13)`

Taper:
```
gradle build
```

## Exécution

Taper:
```
gradle run --console=plain
```

## Documentation

Pour la documentation des API, taper:
```
gradle javadoc
```

puis
```
cd app/build/docs/javadoc
```

* Pour la [Documentation technique](https://gaufre.informatique.univ-paris-diderot.fr/dang/calculatriceevoluee/blob/develop/Documentation/Doc_technique.md)
* Pour le [Manuel utilisateur](https://gaufre.informatique.univ-paris-diderot.fr/dang/calculatriceevoluee/blob/develop/Documentation/Manuel_utilisateur.md)

## Licence

Ce logiciel est distribué sous la licence [MIT](https://gaufre.informatique.univ-paris-diderot.fr/dang/calculatriceevoluee/blob/develop/LICENSE)
