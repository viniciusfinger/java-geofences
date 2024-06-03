# Java Geofences 🗺️🛰️

A geofence system in Java using polygons to define areas on the map. The system is fed with telemetry data to verify positioning and allows the configuration of functionalities for the geofences, such as the detection of entry and exit events from the marked area, in addition to pre-defined infractions, such as speeding within the limits of the fence. When an event or infraction occurs, the system notifies interested parties, ensuring a quick and efficient response.

## Features

- **Geofence Creation**: Define areas on the map using points with latitude and longitude.
- **Telemetry Data**: Feed the system with telemetry data to verify positioning using HTTPS requests or messaging.
- **Event Detection**: Detect entry and exit events from the geofence.
- **Infraction Detection**: Detect infractions, such as speeding within the limits of the fence.
- **Notification System**: Notify interested parties when an event or infraction occurs.

## Prerequisites

Before running the application, ensure you have the following installed:

- **Docker** 🐳 (For containerization)
- **PostGIS** 🌍 (For geospatial data and general persistence)
- **Java 21** ☕️ (For running the application)

## Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/viniciusfinger/java-geofences.git
   ```

2. Run docker in the project root directory:

   ```bash
   docker-compose up
   ```

3. Install maven dependencies:
   ```bash
   mvn install
   ```

## Usage

1. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   
//todo: add more instructions

## Model diagram
//todo: add model diagram

## Customization

Feel free to customize the application to suit your needs. You can modify the geofences implementation, telemetry data processing, event detection, infraction detection, and notification system.
