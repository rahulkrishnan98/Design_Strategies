import unittest
import sys
sys.path.insert(1, '../')
from family import Family
from person import Person
import custom_exceptions

class TestPerson(unittest.TestCase):

    def setUp(self):
        self.person_1 = Person("person1","M")
        self.person_2 = Person("person2","F")
    def test_gender(self):
        self.assertEqual(self.person_1.gender, 'M')
        self.assertEqual(self.person_2.gender, "F")
    def test_name(self):
        self.assertEqual(self.person_1.name, "person1")
        self.assertEqual(self.person_2.name, "person2")


    #All Public methods
    def test_spouse(self):
        self.assertEqual(self.person_1.spouse, None)
    def test_children(self):
        with self.assertRaises(custom_exceptions.ChildAdditionFailed):
            self.person_1.add_children(self.person_2)
    def test_inadequate_information(self):
        with self.assertRaises(custom_exceptions.InadequateInformation):
            self.person_1.get_brother()
        with self.assertRaises(custom_exceptions.InadequateInformation):
            self.person_1.get_sister()
    def test_null_pointer(self):
        with self.assertRaises(custom_exceptions.NullPointer):
            self.person_1.get_paternal_aunt()
        with self.assertRaises(custom_exceptions.NullPointer):
            self.person_1.get_maternal_aunt()
        with self.assertRaises(custom_exceptions.NullPointer):
            self.person_1.get_paternal_uncle()
        with self.assertRaises(custom_exceptions.NullPointer):
            self.person_1.get_maternal_uncle()


if __name__=="__main__":
    unittest.main()