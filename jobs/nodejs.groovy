job('NodeJS example') {
    scm('https://github.com/JoshuaKeys/ci-cd-nodejs.git') { node ->
        node / gitConfigName('Joshua DSL User')
        node / gitConfigEmail('joshua.oguma@outlook.com')
    }

    triggers{
        scm('M/S * * * *')
    }

    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell('npm install')
    }
}