import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label "getUserPrivileges"


    request {
        method GET()
        url "/api/v1/security/"
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