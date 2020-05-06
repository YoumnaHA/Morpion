# Morpion
Projet réalisé en binôme lors de de mon année en DUT Informatique.
IDE : Eclipse
Langage : Java

Le but du projet est de commencer par une application simple et de l'enrichir au fur et à mesure.

1. TicTacToe
Le jeu se joue sur une grille de 3×3. Deux joueurs s’aﬀrontent. Ils doivent remplir chacun à leur tour une case de la grille avec le symbole qui leur est attribué : O ou X. Le gagnant est celui qui arrive le premier à aligner trois symboles identiques, horizontalement, verticalement ou en diagonale. La partie est nulle si toutes les cases sont occupées et qu’aucun joueur n’a réalisé un alignement. Il est coutume de laisser le joueur jouant X eﬀectuer le premier coup de la partie. 
Le joueur saisit le numéro de ligne puis le numéro de colonne en les séparant par un tiret. La saisie de n’importe laquelle des chaînes suivantes devrait être acceptée par votre programme : “1-2”, “01-0002”, “ 1 - 2 ”. 
Si le coup n’est pas valide (la chaîne saisie ne respecte pas le format ci-dessus, les numéros de ligne ou de colonne sont trop petits ou trop grands ou encore si ces numéros d´esignent une case déjà occupée), votre programme doit aﬃcher le message “Coup invalide : ” et attendre la saisie d’un nouveau coup. C’est à votre programme de d´etecter que la ﬁn de partie est atteinte. 

2. Morpion
Dans le jeu de Morpion, les grilles ont une taille quelconque. Les règles du jeu sont modiﬁées comme suit. 
- La partie ne se termine plus au premier alignement mais continue en alternant les coups des deux joueurs jusqu’à ce que toutes les cases soient occupées.
- Un joueur ne peut poser un symbole que sur une case ´etant adjacente (horizontalement, verticalement ou en diagonale) à une case déjà occupée. Au premier coup, le placement est libre.
- Un même symbole ne peut compter que pour un alignement. Dès qu’un alignement est formé, les symboles qui le composent ne peuvent plus concourir à la réalisation d’un autre alignement. Ces symboles sont dits être fermés. Les symboles non encore fermés sont dits être ouverts.
En ﬁn de partie, le joueur ayant fait le plus d’alignements gagne. La partie est nulle en cas d’égalité.
