import unittest
import sys
sys.path.insert(1, '../')
from family import Family
from person import Person
import custom_exceptions

class TestFamily(unittest.TestCase):

    def setUp(self):
        self.King_root = Person("King","M")
        self.family = Family(self.King_root)
        self.person_1 = Person("person1","M")
        self.person_2 = Person("person2","F")
    
    def test_search_functionality(self):
        with self.assertRaises(custom_exceptions.PersonNotFound):
            self.family.search_member(self.person_1)
    def test_child_addition(self):
        with self.assertRaises(custom_exceptions.ChildAdditionFailed):
            self.family.add_child_in_family(self.King_root, self.person_1)
    def test_get_relationship(self):
        with self.assertRaises(custom_exceptions.CommandNotFound):
            self.family.get_relationship("person1","unknown_relation")
    def test_null_values(self):
        with self.assertRaises(custom_exceptions.NullPointer):
            self.family.children(self.King_root, "male")
        with self.assertRaises(custom_exceptions.NullPointer):
            self.family.children(self.King_root, "female")
if __name__=="__main__":
    unittest.main()