# Planer Wydatków
## Opis aplikacji:
Planer Wydatków to prosta aplikacja mobilna na platformę Android, która pomaga zarządzać wydatkami w grupie użytkowników. Pozwala na dodawanie użytkowników, rejestrowanie wydatków oraz automatyczne obliczanie salda dla każdego użytkownika. Aplikacja umożliwia również przegląd historii wydatków i resetowanie danych.

## Funkcjonalności
### 1. Dodawanie użytkowników:

- Możliwość dodania nowego użytkownika do grupy.
- Lista użytkowników jest aktualizowana w czasie rzeczywistym.

### 2. Dodawanie wydatków:

- Rejestrowanie wydatków wraz z opisem, kwotą i osobą płacącą.
- Automatyczne obliczanie bilansów na podstawie wydatków.
- Brak możliwości anulowania wprowadzonego wydatku został skompensowany możliwością wprowadzenie wydatku ze znakiem przeciwnym "-".

### 3. Wyświetlanie salda użytkownika:

- Lista użytkowników wyświetla ich aktualne salda obliczone na podstawie dotychczasowych wydatków.

### 4. Przegląd historii wydatków:

- Dedykowany ekran z listą wszystkich wydatków wraz z ich szczegółami (opis, kwota, osoba płacąca).

### 5. Resetowanie danych:

- Możliwość wyczyszczenia listy użytkowników i wydatków z opcją potwierdzenia.

## Instrukcja obsługi

### 1. Dodawanie użytkownika:

- Na ekranie głównym kliknij przycisk "Add User".
- Wprowadź nazwę użytkownika w nowym oknie i kliknij "Save".

### 2. Dodawanie wydatku:

- Na ekranie głównym kliknij przycisk "Add Expense".
- Wprowadź szczegóły wydatku (opis, kwotę, osobę płacącą) i kliknij "Save".

### 3. Wyświetlanie salda:

- Lista użytkowników na ekranie głównym automatycznie pokazuje salda obok ich nazw.

### 4. Przegląd historii wydatków:

- Kliknij przycisk "View Expense History", aby zobaczyć szczegóły wszystkich dotychczasowych wydatków.

### 5. Resetowanie danych:

- Kliknij przycisk "Reset Data" na ekranie głównym.
- Potwierdź reset, aby usunąć wszystkich użytkowników i wydatki.

## Pliki źródłowe
1. **Główne klasy:**
   - `MainActivity.java` - zarządzanie ekranem głównym, bilansami i przyciskami akcji.
   - `AddUserActivity.java` - dodawanie użytkownika.
   - `AddExpenseActivity.java` - rejestrowanie wydatku.
   - `ExpenseHistoryActivity.java` - wyświetlanie historii wydatków.

2. **Modele:**
   - `User.java` - model użytkownika z polem `balance`.
   - `Expense.java` - model wydatku.

3. **Layouty XML:**
   - `activity_main.xml` - główny ekran aplikacji.
   - `add_user.xml` - widok dodawania użytkownika.
   - `add_expense.xml` - widok dodawania wydatku.
   - `expense_history.xml` - widok historii wydatków.
