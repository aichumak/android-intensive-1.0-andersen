Краткое описание работы приложения:   
При первом запуске приложения выполняются запросы в интернет для получения всех необходимых данных из сети, полученные данные сразу записываются в БД. Пагинация в приложении не реализована. Далее приложение работает только с данными из БД, если в БД данные отсутствуют, все списки будут отображаться пустыми. В приложении не реализована проверка состояния сети, сообщения об отсутствии сети или данных не реализованы. При переходе по вкладкам, при каждом переходе выполняется повторная загрузка данных из сети, прогресс бар загрузки данных не реализован, в момент загрузки данных будут отображаться пустые списки (или заполненные), после загрузки обновленные данные отобразяться в списках.   
Все изображения хранятся в БД в виде url ссылок и загружаются из сети сразу в списки или на экраны детальной информации. При отсутствии сети, некоторые изображения могут не отображаться на экране.  
Приложение реализовано по архитектуре Single Activity, при запуске первоначально загружается splash активити, затем главное активити. Главное активити содержит главный фрагмент контейнер развернутый на весь экран, далее при работе с приложением в этот контейнер загружаются все необходимые фрагменты. Фрагмент главного экрана содержит панель навигации и вториный контейнер фрагментов, в который загружаются фрагменты выбранной вкладки навигации. В приложении полностью реализована навигация по фрагментам. Также во фрагментах детальной информации реализованы клики по полям вью location и origin для перехода во фрагменты детальной информации.   
На главном экране реализованы фильтры и поиск.   
Для загрузки данных из сети и обработки результатов используются библиотеки RxJava2, Retrofiе2, GSON.
Для БД использутся библиотека Room.
Для получения данных из Room используются корутины и suspend функции.     
   

Верхнеуровневое описание курсового проекта  
Андроид.Интенсив 1.0 Andersen  
  
Версия приложения: 1.0  
Имя приложения: Rick and Morty  
Имя пакета: com.example.rickandmorty  
Язык программирования: Kotlin  
Минимальный пакет SDK: API 21  
Максимальный пакет SDK: API 32  
Мастер ветка репозитория:  
https://github.com/aichumak/android-intensive-1.0-andersen.git  
  
При разработке приложения применяются:  
- базовые архитектуры: Clean architecture, Single Activity Architecture  
- базовые паттерны: MVVM
- viewbinding и databinding  
  
Общий план этапов выполнения работ:  
- Верстка UI и создание values  
- Создание Domain слоя  
- Создание Data слоя  
- Создание Presentatin слоя  
- Создание JUnit тестов  
  
1. Верстка UI и создание values:  
1.1 Добавить в res\values\strings.xml новые строки текста:  
"<string name="request_error">Не удалось загрузить данные по запросу:</string>"  
"<string name="characters">персонажи</string>"  
"<string name="locations">локации</string>"  
"<string name="episodes">эпизоды</string>"  
1.2.1 Переименовать макет "activity_main" в "activity_fragment" и класc "MainActivity" в "FragmentActivity", в макете удалить все существующие view  
1.2.2 Добавить в макет "activity_fragment" контейнер для фрагментов groupview FrameLayout:  
	android:id="@+id/main_fragment_container"  
	android:layout_width="match_parent"  
	android:layout_height="match_parent"  
	app:layout_constraintStart_toStartOf="parent"  
	app:layout_constraintTop_toTopOf="parent"  	  
1.3 Создать новый макет фрагмента навигации "fragment_navigation"  
1.3.1 Добавить в макет view BottomNavigationView с тремя вкладками: персонажи, локации, эпизоды  
1.3.2 Создать папку макетов menu, создать макет "bottom_navigation_menu.xml", в макете реализовать три вкладки навигации: персонажи, локации, эпизоды    
1.4 Создать новый макет фрагмента "fragment_list_view"   
1.4.1 Добавить в макет контейнер для фрагментов groupview FrameLayout:  
	android:id="@+id/list_view_fragment_container"  
        android:layout_width="match_parent"  
        android:layout_height="match_parent"  
        app:layout_constraintStart_toStartOf="parent"  
        app:layout_constraintTop_toTopOf="parent"   
1.5 Создать новый макет фрагмента для вывода списка персонажей fragment_character_list  
1.5.1 Добавить в макет groupview RecycleView, который будет отображать список результатов запроса, дизайн реализовать в виде таблицы с 2 столбцами  
1.5.2 Добавить в макет кнопку FloatingButton для вызова экрана фильтра, кнопку расположить в нижнем правом углу макета  
1.6 Создать новый макет фрагмента для вывода списка локаций fragment_location_list  
1.6.1 Добавить в макет groupview RecycleView, который будет отображать список результатов запроса, дизайн реализовать в виде таблицы с 2 столбцами  
1.6.2 Добавить в макет кнопку FloatingButton для вызова экрана фильтра, кнопку расположить в нижнем правом углу макета  
1.7 Создать новый макет фрагмента для вывода списка эпизодов fragment_episode_list  
1.7.1 Добавить в макет groupview RecycleView, который будет отображать список результатов запроса, дизайн реализовать в виде таблицы с 2 столбцами  
1.7.2 Добавить в макет кнопку FloatingButton для вызова экрана фильтра, кнопку расположить в нижнем правом углу макета  
1.8.1 Создать макет экрана фильтра "episodes_filter_cardview", в макет фильтра добавить views для опций: name, episode    
1.8.2 Создать макет экрана фильтра "locations_filter_cardview", в макет фильтра добавить views для опций: name, type, dimension  
1.8.3 Создать макет экрана фильтра "characters_filter_cardview", в макет фильтра добавить views для опций: name, status, species, type, gender  
1.9 В каталоге res\drawable создать иконку поиска в виде "лупы"  
1.9.1 В каталоге res создать новый каталог "menu", в данном каталоге создать макет "menu" для поиска данных в списках RecycleView, в макете реализовать "item" и добавить иконку поиска  
1.10 Создать макет фрагмента деталей персонажа "fragment_character_details"  
1.11 Создать макет фрагмента деталей локации "fragment_location_details"  
1.12 Создать макет фрагмента деталей эпизода "fragment_episode_details"  
1.13 В каталоге res\drawable создать иконку для фильтра   
  
2. Создание Domain слоя  
2.1 Создать класс "GetAllCharactersUseCase" для получения списка персонажей  
2.2 Создать класс "GetAllEpisodesUseCase" для получения списка эпизодов  
2.3 Создать класс "GetAllLocationsUseCase" для получения списка локаций  
2.4 Создать класс "GetSingleCharacterUseCase" для получения данных персонажа  
2.5 Создать класс "GetSingleLocationUseCase" для получения данных локации  
2.6 Создать класс "GetSingleEpisodeUseCase" для получения данных эпизода  
2.7 Создать класс "GetFilteredCharacterUseCase" для получения отфильтрованных данных по персонажу  
2.8 Создать класс "GetFilteredLocationUseCase" для получения отфильтрованных данных по локации  
2.9 Создать класс "GetFilteredEpisodeUseCase" для получения отфильтрованных данных по эпизоду  
2.10 Создать интерфейс "AppRepository", в данном интерфейсе реализовать все функции указанные в п.п. 1.1-1.9  
  
3. Создание Data слоя  
Пока планирую использовать RXJava2 + Retrofit2 + Room + Paging 3, эти библиотеки проходил в одном онлайн-курсе, более менее знаю как использовать   
3.1 В файл "build.gradle" (Module) добавить плагины:  
	id 'kotlin-kapt'  
	id 'kotlin-android-extensions'  
3.2 Импортировать в "build.gradle" следующие зависимости:  
    implementation 'com.squareup.picasso:picasso:2.71828'  
  
    implementation "io.reactivex.rxjava2:rxjava:2.2.6"   
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.9.0'   
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'   
   
    def lifecycle_version = "2.5.0-beta01"   
    // ViewModel   
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")   
    // LiveData   
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")   
    // Annotation processor   
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")   
    // optional - ReactiveStreams support for LiveData   
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")   
   
    def roomVersion = "2.4.2"   
    implementation("androidx.room:room-runtime:$roomVersion")   
    annotationProcessor("androidx.room:room-compiler:$roomVersion")   
    // To use Kotlin annotation processing tool (kapt)   
    kapt("androidx.room:room-compiler:$roomVersion")  
    // optional - Paging 3 Integration   
    implementation("androidx.room:room-paging:2.5.0-alpha01")  
   
    def paging_version = "3.1.1"  
    implementation("androidx.paging:paging-runtime:$paging_version")   
    // optional - RxJava2 support   
    implementation("androidx.paging:paging-rxjava2:$paging_version")   
       
3.3 Для загрузки изображений использовать библиотеку Picasso  
3.4 Создать pojo объекты (классы)  
3.5 Создать абстрактный класс для базы данных, наследоваться от класса RoomDataBase, указать аннотацию @Database, передать в конструктор нужные параметры  
3.6 Создать Dao интерфейс, в интерфейсе создать нужные запросы к базе данных с аннотациями @Query и @Insert  
3.7 Создать object класс "ApiFactory" для работы с библиотекой Retrofit  
3.8 Создать интерфейс "ApiService", создать запросы к ресурсу с аннотациями @GET  
  
4. Создание Presentation слоя  
4.1 Создать интерфейс "ClickListener", в интерфейсе реализовать методы всех кликов  
4.2 Создать интерфейс "FragmentNavigator", в интерфейсе реализовать методы навигации между фрагментами  
4.3 В классе "FragmentActivity" имплементировать вышеуказанные интерфейсы, и переопределить все методы  
4.4 Создать класс "NavigationFragment" который будет отвечать за нижнюю панель навигации на главном экране, наследоваться от класса "Fragment" и передать в конструктор данного класса ссылку на макет "fragment_navigation", реализовать viewbinding  
4.5 Создать классы "CharacterListViewModel", "LocationListViewModel", "EpisodeListViewModel", добавить переменные для репозитория и переменные UseCase классов, реализовать методы UseCase классов  
4.6 Создать классы "CharacterDiffCallback", "LocationDiffCallback", "EpisodeDiffCallback", наследоваться от класса DiffUtil.ItemCallback  
4.7 Создать классы "CharacterViewHolder", "LocationViewHolder", "EpisodeViewHolder", наследоваться от класса RecyclerView.ViewHolder  
4.8 Создать классы "CharacterListAdapter", "LocationListAdapter", "EpisodeListAdapter", наследоваться от androidx.recyclerview.widget.ListAdapter и добавить в конструктор данного класса соответствующие классы адаптеров и коллбэков  
4.9 Создать класс "CharacterListFragment" который будет отвечать за отображение списочных данных по персонажам на главном экране, наследоваться от класса "Fragment" и передать в конструктор данного класса ссылку на макет "fragment_character_list", реализовать viewbinding, добавить вьюмодель класса  "CharacterListViewModel"  
4.10 Создать класс "LocationListFragment" который будет отвечать за отображение списочных данных по локациям на главном экране, наследоваться от класса "Fragment" и передать в конструктор данного класса ссылку на макет "fragment_location_list", реализовать viewbinding, добавить вьюмодель класса "LocationListViewModel"  
4.11 Создать класс "EpisodeListFragment" который будет отвечать за отображение списочных данных по эпизодам на главном экране, наследоваться от класса "Fragment" и передать в конструктор данного класса ссылку на макет "fragment_episode_list", реализовать viewbinding, добавить вьюмодель класса "EpisodeListViewModel"  
4.12 Создать классы "CharacterViewModel", "LocationViewModel", "EpisodeViewModel", добавить переменные для репозитория и переменные UseCase классов, реализовать методы UseCase классов  
4.13 Создать класс "CharacterFragment" который будет отвечать за отображение списочных данных по персонажу на главном экране, наследоваться от класса "Fragment" и передать в конструктор данного класса ссылку на макет "fragment_character_details", реализовать viewbinding, добавить вьюмодель класса "CharacterViewModel"  
4.14 Создать класс "LocationFragment" который будет отвечать за отображение списочных данных по локации на главном экране, наследоваться от класса "Fragment" и передать в конструктор данного класса ссылку на макет "fragment_location_details", реализовать viewbinding, добавить вьюмодель класса "LocationViewModel"  
4.15 Создать класс "EpisodeFragment" который будет отвечать за отображение списочных данных по эпизоду на главном экране, наследоваться от класса "Fragment" и передать в конструктор данного класса ссылку на макет "fragment_episode_details", реализовать viewbinding, добавить вьюмодель класса "EpisodeViewModel"  
  
5 Создать Unit тесты  

История задач:
1. Верстка UI и создание values: Реализовано 
2. Реализовать Data слой: Реализовано  
3. Реализовать Domain слой: Реализовано
4. Реализовать Presentation слой: Реализовано
5. Реализовать Api слой: Реализовано
6. Реализовать DI слой: Не реализовано
7. Приложение должно поддерживать кеширование и иметь возможность работать без интернета: Реализовано  
8. Весь функционал по поиску и фильтрации также должен поддерживать работу без интернета: Реализовано
9. Приложение должно поддерживать навигацию назад: Реализовано
10. На всех экранах, кроме главного, необходимо отображать стрелку назад: Не реализовано
11. Если после выполнения запроса, данных не оказалось, то необходимо показывать соответствующий текст пользователю: Не реализовано
12. Все вкладки должны поддерживать Pull-to-Refresh: Не реализовано
13. В момент загрузки данных необходимо отображать прогресс-индикатор: Не реализовано
14. При открытии приложения должен показываться Splash экран: Реализовано
15. Основной экран должен содержать нижнюю навигацию с 3 вкладками: Реализовано
16. Вкладки должны быть следующими: - персонажи; - локации; - эпизоды: Реализовано
17. После запуска приложения, первым должна отображаться вкладка с персонажами: Реализовано
18. На каждой вкладке должен быть доступ к поиску по данной вкладке, а также возможности отфильтровать: Реализовано
19. Нажатие на элемент из списка должно открывать экран с деталями выбранного объекта: Реализовано
20. Списки необходимо выполнить в виде таблицы с 2 столбцами: Реализовано
21. Экран деталей персонажа со списком: Реализовано
22. Экран деталей локации со списком: Реализовано
23. Экран деталей эпизода со списком: Реализовано
24. Реализация Room БД: Реализовано
25. Использование библиотеки Retrofit2: Реализовано
26. Использование RxJavа2 и Корутин: Реализовано
27. Пагинация: Не реализовано
28. Инжектирование зависимостей с помощью бибилоткеи Dagger2: Не реализовано 
29. JUnit тесты: Не реализовано



