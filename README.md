# Gra w kości – Aplikacja mobilna (Android)

Aplikacja mobilna na system Android symulująca grę w kości, wykonana w ramach zadania zaliczeniowego w środowisku Android Studio.

**Autor:** Imię i nazwisko

---

## Opis aplikacji

Program umożliwia losowanie pięciu kości do gry, wizualizację wylosowanych oczek za pomocą dedykowanych grafik oraz automatyczne zliczanie punktów z pojedynczego rzutu i całej rozgrywki.

### Główne funkcjonalności
- **Rzut kośćmi (`RZUĆ KOŚĆMI`):** losuje 5 liczb całkowitych z zakresu `1–6`, wyświetla odpowiadające im grafiki (`k1.jpg`–`k6.jpg`), oblicza punkty za bieżące losowanie oraz sumuje je do ogólnego wyniku gry.
- **Zasady punktacji:**
  - Punkty przyznawane są wyłącznie za wartości oczek, które wystąpiły w danym rzucie **co najmniej dwa razy** (np. dla rzutu `2, 5, 2, 1, 5` wynik wynosi `2×2 + 5×2 = 14` punktów).
  - Wartości występujące pojedynczo nie są punktowane.
- **Resetowanie gry (`RESETUJ WYNIK`):** zeruje wynik bieżącego losowania oraz całkowity wynik gry i przywraca stan początkowy kości (`question.jpg`).

---

## Technologie i środowisko

- **Środowisko:** Android Studio
- **Język programowania:** Java
- **Interfejs użytkownika:** XML (`LinearLayout` pionowy oraz zagnieżdżony `LinearLayout` poziomy dla kości)

---

## Struktura projektu

```text
app/src/main/
├── java/com/example/grawkosci/
│   └── MainActivity.java       # Logika losowania, obliczania punktów i obsługi przycisków
└── res/
    ├── drawable/               # Grafiki kości (k1.jpg - k6.jpg, question.jpg)
    ├── layout/
    │   └── activity_main.xml   # Układ interfejsu użytkownika
    └── values/
        └── strings.xml         # Zasoby tekstowe aplikacji
