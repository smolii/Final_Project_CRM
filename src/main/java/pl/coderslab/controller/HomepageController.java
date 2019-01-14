package pl.coderslab.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomepageController {



}


//Strona	główna
//Strona	ta	ma	wyświetlać	ostatnio	utworzone	projekty	od	najnowszego	do	najstarszego.
//Limit	projektów	na	stronie	głównej	to	5.
//Strona	ta	ma	wyświetlać	listę	ostatnich	aktywności	użytkowników	systemu	od	najnowszej	do
//najstarszej.
//Limit	na	stronie	głównej	to	25.
//Zastanów	się	i	samodzielnie	opracuj	sposób	na	przechowywanie	danych	o	aktywnościach	-	informacja
//ta	nie	jest	sprecyzowana.
//-----------------------------------------------------------------------------------------
//Strona	główna
//Operacje,	które	mają	się	pojawiać	na	liście	aktywności,	to:
//utworzenie	projektu	-	informacja	kto	i	kiedy	to	zrobił
//dodanie	zadania	do	projektu	-	informacja	kto	i	kiedy	to	zrobił	oraz	do	jakiego	projektu,
//dodatkowo	powinien	się	pojawić	link	do	szczegółów	danego	zagadnienia.
//zmiana	statusu	zadania	-	informacja	kto	i	kiedy	to	zrobił	oraz	z	jakiego	projektu	pochodziło
//zadanie,	dodatkowo	powinien	się	pojawić	link	do	szczegółów	danego	zagadnienia.