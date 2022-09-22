package no.nordicsemi.android.blinky.scanner

import android.bluetooth.BluetoothDevice
import android.os.ParcelUuid
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import no.nordicsemi.android.common.ui.scanner.DeviceSelected
import no.nordicsemi.android.common.ui.scanner.ScannerScreen
import java.util.*

@Composable
fun BlinkyScanner(
    onDeviceSelected: (BluetoothDevice, String?) -> Unit,
) {
    ScannerScreen(
        title = stringResource(id = R.string.scanner_title),
        uuid = ParcelUuid(UUID.fromString("00001523-1212-efde-1523-785feabcd123")), // TODO externalize
        cancellable = false,
        onResult = { result ->
            when (result) {
                is DeviceSelected -> onDeviceSelected(result.device.device, result.device.name)
                else -> {}
            }
        }
    )
}
