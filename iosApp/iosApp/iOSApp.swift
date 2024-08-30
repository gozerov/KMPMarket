import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        PlatformSDK().doInit(platformConfiguration: PlatformConfiguration())
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}