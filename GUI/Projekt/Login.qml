import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

LoginForm {

    Loader {
        anchors.fill: parent

        property bool loginSuccess: false

        source: loginSuccess ? "StartingPagew.qml" : "Login.qml"
    }

}


