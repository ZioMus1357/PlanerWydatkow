# Planer Wydatków
## Opis aplikacji:
Planer Wydatków to prosta aplikacja mobilna na platformę Android, która pomaga zarządzać wydatkami w grupie użytkowników. Pozwala na dodawanie użytkowników, rejestrowanie wydatków oraz automatyczne obliczanie salda dla każdego użytkownika. Aplikacja umożliwia również przegląd historii wydatków i resetowanie danych.
<img src="https://github.com/user-attachments/assets/0b3fbe3e-7154-4d46-a615-507d1b4c51d5" alt="Zrzut ekranu aplikacji" width="400" />


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
![Screenshot_20241203-201313_Expense planner](https://github.com/user-attachments/assets/5c8619e2-af44-4b85-abee-5a24c22461b2)
![Screenshot_20241203-201324_Expense planner](https://github.com/user-attachments/assets/ee4b9fdf-3cb7-461d-bbb7-cd05179128f7)
![Screenshot_20241203-201334_Expense planner](https://github.com/user-attachments/assets/1c3defaa-f0b5-429b-8c68-3b1671f044c3)

### 2. Dodawanie wydatku:

- Na ekranie głównym kliknij przycisk "Add Expense".
- Wprowadź szczegóły wydatku (opis, kwotę, osobę płacącą) i kliknij "Save".
![Screenshot_20241203-201424_Expense planner](https://github.com/user-attachments/assets/085e37a6-5111-454d-bc7c-6af7a0ff788f)
![Screenshot_20241203-201444_Expense planner](https://github.com/user-attachments/assets/8c16f31d-aa63-4949-a75c-c016e738ea60)

### 3. Wyświetlanie salda:

- Lista użytkowników na ekranie głównym automatycznie pokazuje salda obok ich nazw.
![Screenshot_20241203-201452_Expense planner](https://github.com/user-attachments/assets/02222aa5-0812-4bfc-92ba-faf9d1570417)
![Screenshot_20241203-201559_Expense planner](https://github.com/user-attachments/assets/36e4c4ee-738b-49f9-afab-f465330aac3f)


### 4. Przegląd historii wydatków:

- Kliknij przycisk "View Expense History", aby zobaczyć szczegóły wszystkich dotychczasowych wydatków.
![Screenshot_20241203-201523_Expense planner](https://github.com/user-attachments/assets/676834f1-44e9-4250-a3cd-85e7f85227c2)

### 5. Resetowanie danych:

- Kliknij przycisk "Reset Data" na ekranie głównym.
- Potwierdź reset, aby usunąć wszystkich użytkowników i wydatki.
![Screenshot_20241203-201606_Expense planner](https://github.com/user-attachments/assets/b3074104-6f71-42a7-9f0d-689c6d949492)

## Pliki źródłowe
1. **Główne klasy:**
   - `MainActivity.java` - zarządzanie ekranem głównym, bilansami i przyciskami akcji.
   - `AddUserActivity.java` - dodawanie użytkownika.
   - `AddExpenseActivity.java` - rejestrowanie wydatku.
   - `ExpenseHistoryActivity.java` - wyświetlanie historii wydatków.

2. **Modele:**
   - `User.java` - model użytkownika.
   - `Expense.java` - model wydatku.

3. **Layouty XML:**
   - `activity_main.xml` - główny ekran aplikacji.
   - `add_user.xml` - widok dodawania użytkownika.
   - `add_expense.xml` - widok dodawania wydatku.
   - `expense_history.xml` - widok historii wydatków.
