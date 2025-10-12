<img width="721" height="921" alt="uml_vehicle_v1" src="https://github.com/user-attachments/assets/53d12554-abda-47bf-8bde-fdbb4f359992" />

Создан класс Descriptor, который наследует абстрактный класс VehicleDescriptor. 
Класс sealed Vehicle наследует абстрактный класс VehicleDescriptor и использует класс VehicleOption.
VehicleOption - класс для лписания характеристики транспорта.
Классы Car, Plane, Boat, Bicycle являются permit`ами от Vehicle и реализуют логику отдельного вида транспорта.
