# Base change

Conversion de nombres entre la base 10 (décimale) et une base 25, aussi surnommée "alphamérique", sous-ensemble de l'alphabet latin, moins le "o". Les nombres au format alphamérique sont codés sur 4 digits, voici quelques exemples :

- "aaaa" == 0
- "aaab" == 1
- "aaac" == 2
- "aabs" == 42
- "aagh" == 157
- "agdz" == 3849
- "abba" == 650
- "acdc" == 1327
- "cjbg" == 36906
- "zzzz" == 390624

Deux fonctions sont présentes pour les conversions dans les deux sens.

Différents tests unitaires sont présents pour vérifier les points critiques (bornes).

À titre de comparaison "intellectuelle", trois implémentations en Scala 3, Java 11 et Python 3 sont disponibles.


## Alphamérique vers décimale

L'opération mathématique de conversion est la suivante :

- Décomposer la chaine en un tableau de 4 caractères
- Inverser l'ordre du tableau, pour faire correspondre l'indice à l'exposant (plus de simplicité)
- Trouver l'indice dans l'alphabet des (25) symboles correspondant au digit courant et le multiplier par la longueur de l'alphabet à la puissance de l'indice du digit courant

Exemple :

```
"acdc" -> ['a', 'c', 'd', 'c'] -> ['c', 'd', 'c', 'a'] -> 2 * 25⁰ + 3 * 25¹ + 2 * 25² + 0 * 25³ -> 1327
```

## Décimale vers alphamérique

L'opération mathématique de conversion est la suivante :

- Effectuer la division entière du nombre donné par la taille de l'alphabet (25)
- Tant que le quotient obtenu n'est pas égal à zéro, répéter la division avec le nouveau quotient et garder en mémoire les restes successifs des divisions
- Compléter éventuellement avec des zéros pour obtenir un tableau de 4 digits
- Le tableau des restes obtenu correspond aux indices à chercher dans l'alphabet (dans l'ordre inverse)

Exemple :

```
1234 -> ?

Quotient        | Reste            | Restes
1234 / 25 = 49  | 1234 mod 25 = 9  | [9]
49 / 25 = 1     | 49 mod 25 = 24   | [9, 24]
1 / 25 = 0      | 1 mod 25 = 1     | [9, 24, 1] <-- STOP

[9, 24, 1] -> [9, 24, 1, 0] -> [0, 1, 24, 9] -> ['a', 'b', 'z', 'j'] -> "abzj"
```

## Installations et exécutions


### Scala

Nécessite Scala 3 et SBT (1.9.2)

Tests : `sbt test`
Run : `sbt run`


### Java

Nécessite Java 11 et Maven (3.8.5)

Tests : `mvn test`
Run : `mvn compile` puis `mvn exec:java`


### Python

Installation :
```
python3 -m venv .venv
. .venv/bin/activate
```

Runs :
```
cd python
python3 main.py
python3 -m unittest testbasechange
```
