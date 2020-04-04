class Error(Exception):
    pass
class PersonNotFound(Error):
    def __init__(self, message):
        self.message = message
    def __str__(self):
        return self.message
class ChildAdditionFailed(Error):
    def __init__(self, message):
        self.message = message
    def __str__(self):
        return self.message
class InadequateInformation(Error):
    def __init__(self, message):
        self.message = message
    def __str__(self):
        return self.message
class CommandNotFound(Error):
    def __init__(self, message):
        self.message = message
    def __str__(self):
        return self.message
class NullPointer(Error):
    def __init__(self, message):
        self.message = message
    def __str__(self):
        return self.message