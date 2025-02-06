# CarCatalog

## Description
CarCatalog is an Android application that displays a list of cars with their titles, descriptions, and images. This project follows the principles of **Clean Architecture**, the **MVVM** pattern, and utilizes **Kotlin Coroutines**, **Retrofit**, and **Glide**.

## Features
- Display a list of cars with:
    - Model name
    - Brief description
    - Image loaded with Glide
- Fetch data from the **Car Query** API
- Error handling with user-friendly messages
- *(Bonus)* Loading indicator during data retrieval
- *(Bonus)* Pull-to-refresh functionality
- *(Bonus)* Responsive UI for different screen sizes *(Not implemented yet)*

## Technologies Used
- **Kotlin**
- **Jetpack Compose** for UI
- **MVVM** (Model-View-ViewModel)
- **Clean Architecture**
- **Coroutines** for asynchronous processing
- **Retrofit** for API requests
- **Glide** for image loading

## API Used
The application uses the **Car Query** API to fetch car details.
- **Base URL:** [https://www.carqueryapi.com/api/0.3/](https://www.carqueryapi.com/api/0.3/)
- **Example endpoint:** `https://www.carqueryapi.com/api/0.3/?cmd=getModels&make=ford`

## Testing
- **Unit test for ViewModel** *(Not implemented yet)*
- **Unit test for Repository** *(Not implemented yet)*

## Installation & Execution
1. Clone this repository:
   ```bash
   git clone https://github.com/SoufianKm/CarCatalog.git
   ```
2. Open the project in **Android Studio**.
3. Sync dependencies and run the application on an emulator or physical device.

## Author
Developed as part of a technical interview exercise.