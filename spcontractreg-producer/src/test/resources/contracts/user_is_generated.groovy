package contract

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    label "saveUser"

    request {
        method GET()
        url "/api/v1/users/"
    }

    response {
        status OK()
        body([
             id: $(producer(regex(uuid())))
        ])

        headers {
            contentType(applicationJsonUtf8())
        }
    }
}