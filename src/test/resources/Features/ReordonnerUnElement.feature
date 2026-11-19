@ReordonnerListe
Feature: Gestion des interractions

	Scenario: Réordonner un élément
		Given Je suis dans l'onglet sortable
		Then La page se charge correctement avec les onglets "List" et "Grid" visibles
		And L'onglet "List" est actif par défaut
		And L'élément One est affiché
		And L'élément Two est affiché
		And L'élément Three est affiché
		And L'élément Four est affiché
		And L'élément Five est affiché
		And L'élément Six est affiché
		When Faire glisser "Three" vers la position de "One"
		Then L'element "Three" apparaît à la premiére position